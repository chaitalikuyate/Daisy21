package com.testing.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.testing.keywords.UIKeywords;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TestListener implements ITestListener {

	private static final Logger LOG = Logger.getLogger(TestListener.class);

	@Override
	public void onTestFailure(ITestResult result) {
		AShot ashot = new AShot();
		ashot.shootingStrategy(ShootingStrategies.viewportPasting(200));
		Screenshot sc = ashot.takeScreenshot(UIKeywords.getInstance().driver);
		BufferedImage img = sc.getImage();
		String dir = System.getProperty("user.dir");
		System.out.println("current dir" + dir);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyyhhmmss");
		String pattern = format.format(date);
		try {
			LOG.info("takes the Screenshort succesfully");
			ImageIO.write(img, "jpg", new File(dir + "/screenshots/screenshot1_" + pattern + ".jpg"));
		} catch (IOException e) {
			LOG.info("Unable to take screenshot");
			e.printStackTrace();
		}

	}
}
