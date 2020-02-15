/**
 * @jdk����:1.6
 * @�g�{���ɶ�:2010-7-20
 */
package com.mingrisoft.jfreechart.dualAxis;

import java.awt.Color;
import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * �]�w���b���C��
 * @author baiweiming
 *
 */
public class DualAxisDemo5 extends ApplicationFrame {

	public DualAxisDemo5(String title) {
		super(title);
	}

	/**
	 * �إߤ@�Ӹ�ƶ�
	 * 
	 * @return
	 */
	private CategoryDataset getCategoryDataset1() {

		// ������r
		final String series1 = "JAVA�Ϯ�";
		final String series2 = "VC�Ϯ�";
		// �C����r
		final String category1 = "1��";
		final String category2 = "2��";
		final String category3 = "3��";
		final String category4 = "4��";
		final String category5 = "5��";
		final String category6 = "6��";

		// �إߤ����O��ƶ�
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		dataset.addValue(310, series1, category1);
		dataset.addValue(489, series1, category2);
		dataset.addValue(512, series1, category3);
		dataset.addValue(589, series1, category4);
		dataset.addValue(359, series1, category5);
		dataset.addValue(402, series1, category6);

		dataset.addValue(501, series2, category1);
		dataset.addValue(200, series2, category2);
		dataset.addValue(308, series2, category3);
		dataset.addValue(580, series2, category4);
		dataset.addValue(418, series2, category5);
		dataset.addValue(315, series2, category6);

		return dataset;
	}
	
	private CategoryDataset getCategoryDataset2() {
		final String series3 = "VB�Ϯ�";
		// �C����r
		final String category1 = "1��";
		final String category2 = "2��";
		final String category3 = "3��";
		final String category4 = "4��";
		final String category5 = "5��";
		final String category6 = "6��";
		// �إߤ����O��ƶ�
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		dataset.addValue(480, series3, category1);
		dataset.addValue(381, series3, category2);
		dataset.addValue(264, series3, category3);
		dataset.addValue(185, series3, category4);
		dataset.addValue(209, series3, category5);
		dataset.addValue(302, series3, category6);

		return dataset;
	}

	/**
	 * ����JFreeChart
	 * 
	 * @return
	 */
	private JFreeChart getJFreeChart() {
		CategoryDataset dataset = getCategoryDataset1();
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
		categoryPlot.setDataset(1,getCategoryDataset2());
		//�u�εۦ�
        LineAndShapeRenderer renderer2 = new LineAndShapeRenderer();
        //�]�w�u�ι��C��
        renderer2.setSeriesPaint(0, Color.black);
        //�]�w�u�ι�
        categoryPlot.setRenderer(1, renderer2);
        
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
		DualAxisDemo5 demo = new DualAxisDemo5("���b�Ϲ��");
		demo.createPlot();
		demo.pack();
		// �ⵡ����ܨ���ܾ�����
		RefineryUtilities.centerFrameOnScreen(demo);
		// �]�w�i�H���
		demo.setVisible(true);
	}
}
