/**
 * @jdk����:1.6
 * @�g�{���ɶ�:2010-7-20
 */
package com.mingrisoft.jfreechart.bubble;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * ��w��X�b�ث׼��Ҩ���
 * @author baiweiming
 * 
 */
public class BubbleDemo8 extends ApplicationFrame {

	public BubbleDemo8(String title) {
		super(title);
	}

	/**
	 * �إ߸�ƶ�
	 * 
	 * @return
	 */
	private XYZDataset getDataset() {

		// �t������r
		final String series1 = "JAVA�Ϯ�";
		final String series2 = "VC�Ϯ�";
		final String series3 = "VB�Ϯ�";
		
		// �إߤ����O��ƶ�
		DefaultXYZDataset dataset = new DefaultXYZDataset();
		double data1 [] [] =    new double[][] {{600}, {10}, {600/(10*10)}};
		double data2 [] [] =    new double[][] {{650}, {10}, {650/(10*10)}};
		double data3 [] [] =    new double[][] {{800}, {16}, {800/(16*10)}};

		dataset.addSeries(series1, data1);
		dataset.addSeries(series2, data2);
		dataset.addSeries(series3, data3);

		return dataset;
	}

	/**
	 * ����JFreeChart
	 * 
	 * @return
	 */
	private JFreeChart getJFreeChart() {
		XYZDataset dataset = getDataset();
		JFreeChart chart = ChartFactory.createBubbleChart("2010�~�W�b�~�P��q", // �Ϫ���D
				"����", // x�b����
				"����", // y�b����
				dataset, // ��ƶ�
				PlotOrientation.VERTICAL, // �Ϫ��V�G�����B����
				true, // �O�_��ܹϨ�
				false, // �O�_���ͤu��
				false // �O�_����URL�챵
				);
		return chart;
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
		//�ϥ�
		LegendTitle legendTitle = chart.getLegend();
		legendTitle.setItemFont(new Font("�ө���", Font.PLAIN, 14));
		
		XYPlot plot = chart.getXYPlot();
		//X�b
		NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
		domainAxis.setLabelFont(new Font("�ө���", Font.PLAIN, 14));
		//Y�b
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setLabelFont(new Font("�ө���", Font.PLAIN, 14));
	}

	/**
	 * ��s�Ϫ����
	 * 
	 * @param chart
	 */
	private void updatePlot(JFreeChart chart) {
		XYPlot plot = chart.getXYPlot();
		//�]�w�z����
		plot.setForegroundAlpha(0.8f);
		ValueAxis valueAxis = plot.getDomainAxis();
		//��w��X�b�ث׼��Ҩ���
		valueAxis.setVerticalTickLabels(true);

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
		//�ק�Ϫ�
		updatePlot(chart);
		
		setContentPane(new ChartPanel(chart));
	}

	public static void main(String[] args) {
		BubbleDemo8 demo = new BubbleDemo8("��w��");
		demo.createPlot();
		demo.pack();
		// �ⵡ����ܨ���ܾ�����
		RefineryUtilities.centerFrameOnScreen(demo);
		// �]�w�i�H���
		demo.setVisible(true);
	}
}
