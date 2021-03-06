/**
 * @jdk版本:1.6
 * @寫程式時間:2010-7-20
 */
package com.mingrisoft.jfreechart.bar;

import java.awt.Color;
import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BarDemo10 extends ApplicationFrame {

	public BarDemo10(String title) {
		super(title);
	}

	/**
	 * 建立一個資料集
	 * 
	 * @return
	 */
	private CategoryDataset getCategoryDataset() {

		DefaultKeyedValues keyedValues = new DefaultKeyedValues();
		keyedValues.addValue("1月", 310);
		keyedValues.addValue("2月", 489);
		keyedValues.addValue("3月", 512);
		keyedValues.addValue("4月", 589);
		keyedValues.addValue("5月", 359);
		keyedValues.addValue("6月", 402);
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
				"java book", keyedValues);
		return dataset;
	}

	/**
	 * 產生JFreeChart
	 * 
	 * @return
	 */
	private JFreeChart getJFreeChart() {
		CategoryDataset dataset = getCategoryDataset();
		JFreeChart chart = ChartFactory.createBarChart("2010年上半年銷售量", // 圖表標題
				"月份", // x軸標籤
				"銷售量（單位：本）", // y軸標籤
				dataset, // 資料集
				PlotOrientation.VERTICAL, // 圖表方向：水平、垂直
				false, // 是否顯示圖例(對於簡單的柱狀圖必須是false)
				false, // 是否產生工具
				false // 是否產生URL鏈接
				);

		return chart;
	}

	/**
	 * 修改字體
	 * 
	 * @param chart
	 */
	public void updateFont(JFreeChart chart) {

		// 標題
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("細明體", Font.PLAIN, 20));

		// 圖表
		CategoryPlot categoryPlot = chart.getCategoryPlot();

		CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
		// X軸字體
		categoryAxis.setTickLabelFont(new Font("細明體", Font.PLAIN, 14));
		// X軸標籤字體
		categoryAxis.setLabelFont(new Font("細明體", Font.PLAIN, 14));

		ValueAxis valueAxis = categoryPlot.getRangeAxis();
		// y軸字體
		valueAxis.setTickLabelFont(new Font("細明體", Font.PLAIN, 14));
		// y軸標籤字體
		valueAxis.setLabelFont(new Font("細明體", Font.PLAIN, 14));

	}
	
	/**
	 * 更新圖表顯示
	 * @param chart
	 */
	private void updatePlot(JFreeChart chart){
		// 圖表
		CategoryPlot categoryPlot = chart.getCategoryPlot();
		//Y軸（數值軸）
		ValueAxis valueAxis = categoryPlot.getRangeAxis();
		//Y軸尺度顏色
		valueAxis.setAxisLinePaint(Color.GREEN);
		//X軸（分類別軸）
		CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
		//X軸尺度顏色
		categoryAxis.setAxisLinePaint(Color.GREEN);
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
		//修改圖表
		updatePlot(chart);
		// 把JFreeChart面板儲存在窗體裡
		setContentPane(new ChartPanel(chart));

	}

	public static void main(String[] args) {
		BarDemo10 barDemo = new BarDemo10("柱形圖實例");
		barDemo.createPlot();
		barDemo.pack();
		// 把窗體顯示到顯示器中央
		RefineryUtilities.centerFrameOnScreen(barDemo);
		// 設定可以顯示
		barDemo.setVisible(true);

	}
}
