/**
 * @jdk����:1.6
 * @�g�{���ɶ�:2010-7-20
 */
package com.mingrisoft.jfreechart.pie;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.TableOrder;

public class PieDemo11 extends ApplicationFrame {

	public PieDemo11(final String title) {
		super(title);

	}

	/**
	 * �إ߸�ƶ�
	 * 
	 * @return
	 */
	private CategoryDataset createDataset() {
		 double[][] data = new double[][] {
				{ 620, 410, 300 },
				{ 300, 390, 500 } };
		 CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
				"Dept",//��W�� 
				"Month",//�C�W��
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
		JFreeChart chart = ChartFactory.createMultiplePieChart(
				"4-6 month sales ranking ", // ��ϼ��D
				dataset, // ��ƶ�
				TableOrder.BY_ROW, // �ƧǤ覡
				true, true, false);
		return chart;
	}

	/**
	 * �إ߻��
	 */
	public void createPiePlot() {
		JFreeChart chart = getJFreeChart();
		setContentPane(new ChartPanel(chart));
	}

	public static void main(final String[] args) {

		final PieDemo11 demo = new PieDemo11("��Ϲ��");
		demo.createPiePlot();
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);

	}

}
