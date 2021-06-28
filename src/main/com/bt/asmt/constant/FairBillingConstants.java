package main.com.bt.asmt.constant;

import main.com.bt.asmt.enums.Status;

public class FairBillingConstants {
	private FairBillingConstants() {
	};

	public static final String SPLIT_PATTERN = "\\s+";
	public static final String LOG_VALID_PATTERN = "\\b([01]?\\d|2[0-3]):([0-5]?\\d):([0-5]?\\d)\\s+\\w+\\s+((?i)"
			+ Status.START + "|" + Status.END + ")\\b";
	public static final String TIMESTAMP_FORMAT ="HH:mm:ss";
}
