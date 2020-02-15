/**
 * @jdk����:1.6
 * @�g�{���ɶ�:2010-7-20
 */
package com.mingrisoft.jfreechart.timeSeries;

import java.awt.Color;
import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Month;
import org.jfree.data.time.Quarter;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * �W�[X�b�аO
 * 
 * @author baiweiming
 * 
 */
public class TimeSeriesDemo7 extends ApplicationFrame {

	public TimeSeriesDemo7(String title) {
		super(title);
	}

	/**
	 * �إ߸�ƶ�
	 * 
	 * @return
	 */
	private XYDataset getDataset() {

		final TimeSeries s1 = new TimeSeries("JAVA�Ϯ�");
		s1.add(new Month(1, 2010), 480);
		s1.add(new Month(2, 2010), 381);
		s1.add(new Month(3, 2010), 264);
		s1.add(new Month(4, 2010), 185);
		s1.add(new Month(5, 2010), 209);
		s1.add(new Month(6, 2010), 302);

		final TimeSeries s2 = new TimeSeries("VC�Ϯ�");
		s2.add(new Month(1, 2010), 315);
		s2.add(new Month(2, 2010), 418);
		s2.add(new Month(3, 2010), 580);
		s2.add(new Month(4, 2010), 308);
		s2.add(new Month(5, 2010), 200);
		s2.add(new Month(6, 2010), 501);

		final TimeSeries s3 = new TimeSeries("VB�Ϯ�");
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
	 * ����JFreeChart
	 * 
	 * @return
	 */
	private JFreeChart getJFreeChart() {
		XYDataset dataset = getDataset();
		JFreeChart chart = ChartFactory.createTimeSeriesChart("2010�~�W�b�~�P��q", // �Ϫ���D
				"���", // x�b����
				"�P��q�]���G���^", // y�b����
				dataset, // ��ƶ�
				true, // �O�_��ܹϨ�
				false, // �O�_���ͤu��
				false // �O�_����URL�챵
				);
		return chart;
	}

	/**
	 * ��s�Ϫ����
	 * 
	 * @param chart
	 */
	private void updatePlot(JFreeChart chart) {
		// �����O�Ϫ�
		XYPlot xyPlot = chart.getXYPlot();
		// �bX�b�W�[�u�׼аO
		Quarter quarter = new Quarter(2, 2010);
		ValueMarker marker = new ValueMarker(quarter.getFirstMillisecond());
		marker.setPaint(Color.ORANGE);
		//�W�[�аO
		xyPlot.addDomainMarker(marker);

	}

	/**
	 * �ק�r��
	 * 
	 * @param chart
	 */
	private void updateFont(JFreeChart chart) {

		// ���D
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("�ө���", Font.PLAIN, 20));
		LegendTitle legendTitle = chart.getLegend();
		legendTitle.setItemFont(new Font("�ө���", Font.PLAIN, 14));

		// �Ϫ�
		XYPlot xyPlot = chart.getXYPlot();

		ValueAxis domainyAxis = xyPlot.getDomainAxis();
		// X�b�r��
		domainyAxis.setTickLabelFont(new Font("�ө���", Font.PLAIN, 14));
		// X�b���Ҧr��
		domainyAxis.setLabelFont(new Font("�ө���", Font.PLAIN, 14));

		ValueAxis rangeAxis = xyPlot.getRangeAxis();
		// y�b�r��
		rangeAxis.setTickLabelFont(new Font("�ө���", Font.PLAIN, 14));
		// y�b���Ҧr��
		rangeAxis.setLabelFont(new Font("�ө���", Font.PLAIN, 14));
	}

	/**
	 * �]�w�Ϫ�
	 * 
	 * @param chart
	 */
	public void createPlot() {
		JFreeChart chart = getJFreeChart();
		// �ק�r��
		updateFont(chart);
		// �ק�Ϫ�
		updatePlot(chart);
		setContentPane(new ChartPanel(chart));
	}

	public static void main(String[] args) {
		TimeSeriesDemo7 barDemo = new TimeSeriesDemo7("�ɧǹ�");
		barDemo.createPlot();
		barDemo.pack();
		// �ⵡ����ܨ���ܾ�����
		RefineryUtilities.centerFrameOnScreen(barDemo);
		// �]�w�i�H���
		barDemo.setVisible(true);
	}
}
