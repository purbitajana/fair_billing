package main.com.bt.asmt.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import main.com.bt.asmt.constant.FairBillingConstants;
import main.com.bt.asmt.enums.Status;
import main.com.bt.asmt.exception.FairBillingException;
import main.com.bt.asmt.model.Session;

public class FairBillingUtility {
	private SimpleDateFormat sdf = new SimpleDateFormat(FairBillingConstants.TIMESTAMP_FORMAT);
	/*
	 * This method gets a log file name, validates and process each valid lines to
	 * provide list of sessions
	 * 
	 * @param fileName absolute path of a log file generated by the fair billing
	 * application
	 * 
	 * @return list of valid session data
	 */
	public List<Session> getSessionsFromLog(String fileName) {
		// reading file as a stream
		try (Stream<String> logStream = Files.lines(Paths.get(fileName))) {
			List<Session> sessionList = new ArrayList<>();
			Pattern pattern = Pattern.compile(FairBillingConstants.LOG_VALID_PATTERN);
			AtomicInteger lineNum = new AtomicInteger(0);

			logStream.forEach(line -> {
				lineNum.incrementAndGet();
				Matcher matcher = pattern.matcher(line);
				// checking for each line if it is a valid session log
				if (matcher.find()) {
					String sessionStr = matcher.group();
					// getting array of timeStamp,username and session status for each line
					String[] sessionStrArr = sessionStr.split(FairBillingConstants.SPLIT_PATTERN);
					// preparing the session object from valid log line
					Session session = prepareSession(sessionStrArr, lineNum.intValue());
					if (session != null) {
						sessionList.add(session);
					}
				} else {
					// logging info for ignoring an invalid line
					System.out.println(String.format("Line number %d is not a valid line to process. Hence ignoring.",
							lineNum.intValue()));
				}
			});
			return sessionList;

		} catch (IOException e) {
			// throwing exception if file read error occurs including file not found
			throw new FairBillingException(String.format("Error occurred while reading log file->%s", e.getMessage()));
		}

	}

	/*
	 * This method takes a valid log line as input and prepares an instance of
	 * session
	 * 
	 * @param sessionStrArr will contain splitted log line data
	 * 
	 * @param lineNum represents the line number of the log line in file
	 * 
	 * @return session data
	 */
	private Session prepareSession(String[] sessionStrArr, int lineNum) {
		try {
			return new Session(sdf.parse(sessionStrArr[0]), sessionStrArr[1],
					Status.valueOf(sessionStrArr[2].toUpperCase()));

		} catch (ParseException e) {
			System.out.println(String.format("Unable to parse date %s at line number %d. Hence ignoring.",
					sessionStrArr[0], lineNum));
			return null;
		}
	}
}
