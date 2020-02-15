/**
 * @jdk����:1.6
 * @�g�{���ɶ�:2010-7-20
 */
package com.mingrisoft.jfreechart.pie;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.TableOrder;

public class PieDemo14 extends ApplicationFrame {

	public PieDemo14(final String title) {
		super(title);

	}

	/**
	 * �إ߸�ƶ�
	 * 
	 * @return
	 */
	private CategoryDataset createDataset() {
		 double[][] data = new double[][] {
				{ 620, 410, 310 },
				{ 300, 390, 500 } };
		 CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
				"����",//��W�� 
				"���",//�C�W��
				data);
		return dataset;
	}

	/**
	 * ��o��ƶ��A����JFreeChart�A
	 * 
	 * @return
	 */
	private JFreeChart getJFreeChart() {
		CategoryDataset dataset = createDataset();
		JFreeChart chart = ChartFactory.createMultiplePieChart3D(
				"4-6��P��Ʀ�", // ��ϼ��D
				dataset, // ��ƶ�
				TableOrder.BY_COLUMN, // �ƧǤ覡
				true, true, false);
		return chart;
	}

	/**
	 * �إ߻��
	 */
	public void createPiePlot() {
		JFreeChart chart = getJFreeChart();
		// ������D
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("�ө���", Font.BOLD, 20));

		// �Ϩ�
		LegendTitle legendTitle = chart.getLegend();
		legendTitle.setItemFont(new Font("�ө���", Font.PLAIN, 14));
		
		
		MultiplePiePlot multiplePiePlot = (MultiplePiePlot) chart.getPlot();
		JFreeChart jFreeChart = multiplePiePlot.getPieChart();

		// �Ϫ����
		PiePlot3D piePlot = (PiePlot3D) jFreeChart.getPlot();

		piePlot.setLabelFont(new Font("�ө���", Font.PLAIN, 14));
		piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator(
				"{0}:{1}"));
		// �Ϫ���D
		TextTitle textTitle2 = jFreeChart.getTitle();
		textTitle2.setFont(new Font("�ө���", Font.BOLD, 20));
		
		
		setContentPane(new ChartPanel(chart));
	}

	public static void main(final String[] args) {

		final PieDemo14 demo = new PieDemo14("��Ϲ��");
		demo.createPiePlot();
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);

	}

}
