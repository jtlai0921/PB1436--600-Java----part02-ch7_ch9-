/**
 * @jdk����:1.6
 * @�g�{���ɶ�:2010-7-20
 */
package com.mingrisoft.jfreechart;

import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.Align;

public class ChartDemo8 {

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
	 * �]�w��ϭI����
	 * 
	 * @param chart
	 */
	public void setBackgroundImage(JFreeChart chart) {

		Image image = null;
		try {
			image = ImageIO.read(new File("backgroundImage.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PiePlot piePlot = (PiePlot) chart.getPlot();
		piePlot.setBackgroundImage(image);
		//�]�w�I�����
		piePlot.setBackgroundImageAlignment(Align.CENTER);
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
		ChartDemo8 demo = new ChartDemo8();
		JFreeChart chart = demo.getJFreeChart();
		demo.setPiePoltFont(chart);
		demo.setBackgroundImage(chart);
		ChartFrame chartFrame = new ChartFrame("JFreeChart���Ҥl", chart);
		chartFrame.pack();
		chartFrame.setVisible(true);

	}
}
