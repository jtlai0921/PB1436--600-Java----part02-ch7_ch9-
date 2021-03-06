/**
 * @jdk版本:1.6
 * @寫程式時間:2010-7-20
 */
package com.mingrisoft.jfreechart.timeSeries;

import java.awt.Font;
import java.text.SimpleDateFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * 雙時間軸位置 
 * @author baiweiming
 * 
 */
public class TimeSeriesDemo4 extends ApplicationFrame {

	public TimeSeriesDemo4(String title) {
		super(title);
	}

	/**
	 * 建立資料集
	 * 
	 * @return
	 */
	private XYDataset getDataset() {

		final TimeSeries s1 = new TimeSeries("JAVA圖書");
		s1.add(new Month(1, 2010), 480);
		s1.add(new Month(2, 2010), 381);
		s1.add(new Month(3, 2010), 264);
		s1.add(new Month(4, 2010), 185);
		s1.add(new Month(5, 2010), 209);
		s1.add(new Month(6, 2010), 302);

		final TimeSeries s2 = new TimeSeries("VC圖書");
		s2.add(new Month(1, 2010), 315);
		s2.add(new Month(2, 2010), 418);
		s2.add(new Month(3, 2010), 580);
		s2.add(new Month(4, 2010), 308);
		s2.add(new Month(5, 2010), 200);
		s2.add(new Month(6, 2010), 501);

		final TimeSeries s3 = new TimeSeries("VB圖書");
		s3.add(new Month(1, 2010), 310);
		s3.add(new Month(2, 2010), 489);
		s3.add(new Month(3, 2010), 512);
		s3.add(new Month(4, 2010), 589);
		s3.add(new Month(5, 2010), 359);
		s3.add(new Month(6, 2010), 402);

		final TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(s1);
		dataset.addSeries(s2);
		dataset.addSeries(s3);

		return dataset;

	}

	/**
	 * 產生JFreeChart
	 * 
	 * @return
	 */
	private JFreeChart getJFreeChart() {
		XYDataset dataset = getDataset();
		JFreeChart chart = ChartFactory.createTimeSeriesChart("2010年上半年銷售量", // 圖表標題
				"月份", // x軸標籤
				"銷售量（單位：本）", // y軸標籤
				dataset, // 資料集
				true, // 是否顯示圖例
				false, // 是否產生工具
				false // 是否產生URL鏈接
				);
		return chart;
	}

	/**
	 * 更新圖表顯示
	 * 
	 * @param chart
	 */
	private void updatePlot(JFreeChart chart) {
		// 分類別圖表
		XYPlot xyPlot = chart.getXYPlot();
		DateAxis dateAxis = (DateAxis) xyPlot.getDomainAxis();
		//設定顯示格式
		dateAxis.setDateFormatOverride(new SimpleDateFormat("yyyy-MM"));

		//增加時間軸
		DateAxis dateAxis1 = new DateAxis();
		dateAxis1.setRange(new Month(1, 2010).getStart(), new Month(7, 2010).getEnd());
		dateAxis1.setDateFormatOverride(new SimpleDateFormat("yyyy-MMM"));
		xyPlot.setDomainAxis(1,dateAxis1);
		//設定時間軸
		xyPlot.setDomainAxisLocation(1, AxisLocation.BOTTOM_OR_LEFT);

	}

	/**
	 * 修改字體
	 * 
	 * @param chart
	 */
	private void updateFont(JFreeChart chart) {

		// 標題
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("細明體", Font.PLAIN, 20));
		LegendTitle legendTitle = chart.getLegend();
		legendTitle.setItemFont(new Font("細明體", Font.PLAIN, 14));

		// 圖表
		XYPlot xyPlot = chart.getXYPlot();

		ValueAxis domainyAxis = xyPlot.getDomainAxis();
		// X軸字體
		domainyAxis.setTickLabelFont(new Font("細明體", Font.PLAIN, 14));
		// X軸標籤字體
		domainyAxis.setLabelFont(new Font("細明體", Font.PLAIN, 14));

		ValueAxis rangeAxis = xyPlot.getRangeAxis();
		// y軸字體
		rangeAxis.setTickLabelFont(new Font("細明體", Font.PLAIN, 14));
		// y軸標籤字體
		rangeAxis.setLabelFont(new Font("細明體", Font.PLAIN, 14));
	}

	/**
	 * 設定圖表
	 * 
	 * @param chart
	 */
	public void createPlot() {
		JFreeChart chart = getJFreeChart();
		// 修改字體
		updateFont(chart);
		// 修改圖表
		updatePlot(chart);
		setContentPane(new ChartPanel(chart));
	}

	public static void main(String[] args) {
		TimeSeriesDemo4 demo = new TimeSeriesDemo4("時序圖");
		demo.createPlot();
		demo.pack();
		// 把窗體顯示到顯示器中央
		RefineryUtilities.centerFrameOnScreen(demo);
		// 設定可以顯示
		demo.setVisible(true);
	}
}
