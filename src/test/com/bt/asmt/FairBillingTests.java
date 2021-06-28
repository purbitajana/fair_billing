package test.com.bt.asmt;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

import main.com.bt.asmt.exception.FairBillingException;
import main.com.bt.asmt.model.ReportData;
import main.com.bt.asmt.service.FairBillingService;

public class FairBillingTests {

	private FairBillingService service = new FairBillingService();
	private Path resourceDirectory = Paths.get("src", "test", "resources");
	private String absolutePath = resourceDirectory.toFile().getAbsolutePath();

	@Test
	public void givenValidSessionLog_whenPrintingReportData_thenValidReport() {
		List<ReportData> rptDataList = service.printReport(absolutePath + "/fair_billing1.log");
		Assert.assertEquals(4, rptDataList.size());
		Optional<ReportData> rptData1 = rptDataList.stream().filter(report -> report.getUserName().equals("John"))
				.findAny();
		Assert.assertEquals(Boolean.TRUE, rptData1.isPresent());
		if (rptData1.isPresent()) {
			Assert.assertEquals(3, rptData1.get().getSessionCount());
			Assert.assertEquals(684, rptData1.get().getDuration());
		}

		Optional<ReportData> rptData2 = rptDataList.stream().filter(report -> report.getUserName().equals("ALICE99"))
				.findAny();
		Assert.assertEquals(Boolean.TRUE, rptData2.isPresent());
		if (rptData2.isPresent()) {
			Assert.assertEquals(10, rptData2.get().getSessionCount());
			Assert.assertEquals(808, rptData2.get().getDuration());
		}
		Optional<ReportData> rptData3 = rptDataList.stream().filter(report -> report.getUserName().equals("CHARLIE"))
				.findAny();
		Assert.assertEquals(Boolean.TRUE, rptData3.isPresent());
		if (rptData3.isPresent()) {
			Assert.assertEquals(5, rptData3.get().getSessionCount());
			Assert.assertEquals(260, rptData3.get().getDuration());
		}
		Optional<ReportData> rptData4 = rptDataList.stream().filter(report -> report.getUserName().equals("SAM"))
				.findAny();

		Assert.assertEquals(Boolean.TRUE, rptData4.isPresent());
		if (rptData4.isPresent()) {
			Assert.assertEquals(4, rptData4.get().getSessionCount());
			Assert.assertEquals(502, rptData4.get().getDuration());
		}
	}

	@Test(expected = FairBillingException.class)
	public void givenEmptySessionLog_whenPrintingReportData_thenError() {
		service.printReport(absolutePath + "/fair_billing2.log");
	}

	@Test
	public void givenInvalidTimeStamp_whenPrintingReportData_thenIgnore() {
		List<ReportData> rptDataList = service.printReport(absolutePath + "/fair_billing3.log");
		Assert.assertEquals(2, rptDataList.size());
		Optional<ReportData> rptData1 = rptDataList.stream().filter(report -> report.getUserName().equals("John"))
				.findAny();
		Assert.assertEquals(Boolean.FALSE, rptData1.isPresent());
	}

	@Test
	public void givenInvalidStatus_whenPrintingReportData_thenIgnore() {
		List<ReportData> rptDataList = service.printReport(absolutePath + "/fair_billing4.log");
		Assert.assertEquals(2, rptDataList.size());
		Optional<ReportData> rptData1 = rptDataList.stream().filter(report -> report.getUserName().equals("CHARLIE"))
				.findAny();
		Assert.assertEquals(Boolean.FALSE, rptData1.isPresent());
	}

	@Test(expected = FairBillingException.class)
	public void givenNonExistingFile_whenPrintingReportData_thenErrror() {
		service.printReport(absolutePath + "/fair_billing5.log");

	}
}
