/**
 * @jdk����:1.6
 * @�g�{���ɶ�:2010-7-20
 */
package com.mingrisoft.jfreechart.bar;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.CategoryTextAnnotation;
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

public class BarDemo36 extends ApplicationFrame {

	public BarDemo36(String title) {
		super(title);
	}

	/**
	 * �إߤ@�Ӹ�ƶ�
	 * 
	 * @return
	 */
	private CategoryDataset getCategoryDataset() {

		DefaultKeyedValues keyedValues = new DefaultKeyedValues();
		keyedValues.addValue("1��", 310);
		keyedValues.addValue("2��", 489);
		keyedValues.addValue("3��", 512);
		keyedValues.addValue("4��", 589);
		keyedValues.addValue("5��", 359);
		keyedValues.addValue("6��", 402);
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
		JFreeChart chart = ChartFactory.createBarChart("2010�~�W�b�~�P��q", // �Ϫ���D
				"���", // x�b����
				"�P��q�]���G���^", // y�b����
				dataset, // ��ƶ�
				PlotOrientation.VERTICAL, // �Ϫ��V�G�����B����
				true, // �O�_��ܹϨ�(���²�檺�W���ϥ����Ofalse)
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
	 * ��s�Ϫ����
	 * 
	 * @param chart
	 */
	private void updatePlot(JFreeChart chart) {
		// �Ϫ�
		CategoryPlot categoryPlot = chart.getCategoryPlot();
		//�]�w�¤�r����
		CategoryTextAnnotation annotation = new CategoryTextAnnotation("310","1��",310);
		CategoryTextAnnotation annotation1 = new CategoryTextAnnotation("489","2��",489);
		CategoryTextAnnotation annotation2 = new CategoryTextAnnotation("512","3��",512);
		CategoryTextAnnotation annotation3 = new CategoryTextAnnotation("589","4��",589);
		CategoryTextAnnotation annotation4 = new CategoryTextAnnotation("359","5��",359);
		CategoryTextAnnotation annotation5 = new CategoryTextAnnotation("402","6��",402);
		//�]�w�����������I
		annotation.setRotationAngle(Math.PI*0.2);
		annotation1.setRotationAngle(Math.PI*0.2);
		annotation2.setRotationAngle(Math.PI*0.2);
		annotation3.setRotationAngle(Math.PI*0.2);
		annotation4.setRotationAngle(Math.PI*0.2);
		annotation5.setRotationAngle(Math.PI*0.2);
		//�W�[����
		categoryPlot.addAnnotation(annotation);
		categoryPlot.addAnnotation(annotation1);
		categoryPlot.addAnnotation(annotation2);
		categoryPlot.addAnnotation(annotation3);
		categoryPlot.addAnnotation(annotation4);
		categoryPlot.addAnnotation(annotation5);
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
		// ��JFreeChart���O�x�s�b�����
		setContentPane(new ChartPanel(chart));
	}

	public static void main(String[] args) {
		BarDemo36 barDemo = new BarDemo36("�W�ιϹ��");
		barDemo.createPlot();
		barDemo.pack();
		// �ⵡ����ܨ���ܾ�����
		RefineryUtilities.centerFrameOnScreen(barDemo);
		// �]�w�i�H���
		barDemo.setVisible(true);

	}
}
