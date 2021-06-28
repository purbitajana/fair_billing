package main.com.bt.asmt;

import main.com.bt.asmt.exception.FairBillingException;
import main.com.bt.asmt.service.FairBillingService;

public class FairBilling {
	
	public static void main(String[] args) {
		//checking if argument for log file is passed or not and throwing exception if not passed
		if(args.length ==0)
		{
			throw new FairBillingException("Please provide log file name to process.");
		}
		if (args.length >0) {
			//if more than one arguments are passed considering the first argument
			if(args.length >1)
			{
				System.out.println("More than 1 arguments are passed. Hence considering the first one and ignoring rests.");
			}
			//calling the service to print the report
			new FairBillingService().printReport(args[0]);
		} 
	
	}

	

}
