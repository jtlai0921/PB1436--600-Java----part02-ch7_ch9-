/**
 * @jdk����:1.6
 * @�g�{���ɶ�:2010-7-20
 */
package com.mingrisoft.jfreechart;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class ChartDemo6 {

	/**
	 * ����JFreeChart
	 * 
	 * @return
	 */
	public JFreeChart getJFreeChart() {
		PieDataset dataset = getPieDataset();
		// locale.getISO3Language()
		JFreeChart chart = ChartFactory.createPieChart("2010.8����P��Ʀ�", dataset,
				true, true, false);
		//�����ܿ���
		chart.setAntiAlias(false);

		return chart;
	}

	/**
	 * �]�w��ϨϥΪ��r��
	 * 
	 * @param chart
	 */
	public void setPiePoltFont(JFreeChart chart) {

		// �Ϫ�(���)
		PiePlot piePlot = (PiePlot) chart.getPlot();
		piePlot.setLabelFont(new Font("�ө���", Font.PLAIN, 14));
		piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator("{1}"));

		// ���D
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("�ө���", Font.BOLD, 20));

		// �Ϩ�
		LegendTitle legendTitle = chart.getLegend();
		legendTitle.setItemFont(new Font("�ө���", Font.PLAIN, 12));

	}


	/**
	 * �إߤ@�ӻ�Ϫ���ƶ�
	 * 
	 * @return
	 */
	private PieDataset getPieDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("JAVA�q�J�����q�]��2���^", 500);
		dataset.setValue("���T��JAVA", 800);
		dataset.setValue("JAVA����t�d�_��", 1000);
		return dataset;
	}

	public static void main(String[] args) {
		ChartDemo6 demo = new ChartDemo6();
		JFreeChart chart = demo.getJFreeChart();
		demo.setPiePoltFont(chart);
		ChartFrame chartFrame = new ChartFrame("JFreeChart���Ҥl", chart);
		chartFrame.pack();
		chartFrame.setVisible(true);
	}
}
