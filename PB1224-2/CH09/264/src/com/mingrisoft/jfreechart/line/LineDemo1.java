package com.mingrisoft.jfreechart.line;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * �򥻻E�X�u��
 * @author baiweiming
 *
 */
public class LineDemo1 extends ApplicationFrame {

	public LineDemo1(String title) {
		super(title);
	}

	/**
	 * �إߤ@�Ӹ�ƶ�
	 * 
	 * @return
	 */
	private CategoryDataset getCategoryDataset() {

		DefaultKeyedValues keyedValues = new DefaultKeyedValues();
		keyedValues.addValue("1", 310);
		keyedValues.addValue("2", 489);
		keyedValues.addValue("3", 512);
		keyedValues.addValue("4", 589);
		keyedValues.addValue("5", 359);
		keyedValues.addValue("6", 402);
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
				"JAVA�Ϯ�", keyedValues);
		return dataset;
	}


	/**
	 * ����JFreeChart
	 * 
	 * @return
	 */
	private JFreeChart getJFreeChart() {
		CategoryDataset dataset = getCategoryDataset();
		JFreeChart chart = ChartFactory.createLineChart("2010�~�W�b�~�P��q", // �Ϫ���D
				"���", // x�b����
				"�P��q�]���G���^", // y�b����
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
		LegendTitle legendTitle = chart.getLegend();
		legendTitle.setItemFont(new Font("�ө���", Font.PLAIN, 14));
		// �Ϫ�
		CategoryPlot categoryPlot = chart.getCategoryPlot();

		CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
		// X�b�r��
		categoryAxis.setTickLabelFont(new Font("�ө���", Font.PLAIN, 14));
		// X�b���Ҧr��
		categoryAxis.setLabelFont(new Font("�ө���", Font.PLAIN, 14));

		ValueAxis valueAxis = categoryPlot.getRangeAxis();
		// y�b�r��
		valueAxis.setTickLabelFont(new Font("�ө���", Font.PLAIN, 14));
		// y�b���Ҧr��
		valueAxis.setLabelFont(new Font("�ө���", Font.PLAIN, 14));
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
		setContentPane(new ChartPanel(chart));
	}

	public static void main(String[] args) {
		LineDemo1 demo = new LineDemo1("�E�X�u��");
		demo.createPlot();
		demo.pack();
		// �ⵡ����ܨ���ܾ�����
		RefineryUtilities.centerFrameOnScreen(demo);
		// �]�w�i�H���
		demo.setVisible(true);

	}

}
