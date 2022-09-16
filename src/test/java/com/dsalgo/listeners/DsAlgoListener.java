package com.dsalgo.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.dsalgo.dsbase.DsAlgoBase;
import com.dsalgo.util.DsAlgoUtil;

public class DsAlgoListener extends DsAlgoBase implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Inside OnTestStart" + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			DsAlgoUtil.takeSnapShot(driver,result.getName()+".png");
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot...");
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
	}

}
