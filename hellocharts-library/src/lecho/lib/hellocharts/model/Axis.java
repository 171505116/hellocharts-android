package lecho.lib.hellocharts.model;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.graphics.Typeface;

import lecho.lib.hellocharts.util.Utils;

/**
 * Single axis model. By default axis is auto-generated. Use {@link #setAutoGenerated(boolean)} to disable axis values
 * generation and set values manually using {@link #setValues(List)}. If Axis is auto-generated {@link #setValues(List)}
 * will be ignored. Change how axis labels are displayed by changing formatter {@link #setFormatter(ValueFormatter)}.
 * Axis can have a name that should be displayed next to labels(that depends on renderer implementation), you can change
 * name using {@link #setName(String)}, by default axis name is empty and therefore not displayed.
 * 
 * @author Leszek Wach
 * 
 */
public class Axis {
	public static final int DEFAULT_TEXT_SIZE_SP = 12;
	public static final int DEFAULT_MAX_AXIS_LABEL_CHARS = 4;
	private List<AxisValue> values = new ArrayList<AxisValue>();
	private String name;
	private boolean isAutoGenerated = true;
	private boolean hasLines = false;
	private int textColor = Color.LTGRAY;
	private int lineColor = Utils.DEFAULT_DARKEN_COLOR;
	private int textSize = DEFAULT_TEXT_SIZE_SP;
	private int maxLabelChars = DEFAULT_MAX_AXIS_LABEL_CHARS;
	private Typeface typeface;
	private ValueFormatter formatter = new SimpleValueFormatter();

	/**
	 * Creates auto-generated axis without name and with default formatter.
	 * 
	 * @see SimpleValueFormatter
	 */
	public Axis() {
	}

	/**
	 * Creates axis with given values(not auto-generated) without name and with default formatter.
	 */
	public Axis(List<AxisValue> values) {
		setValues(values);
	}

	public Axis(Axis axis) {
		this.name = axis.name;
		this.isAutoGenerated = axis.isAutoGenerated;
		this.hasLines = axis.hasLines;
		this.textColor = axis.textColor;
		this.lineColor = axis.lineColor;
		this.textSize = axis.textSize;
		this.maxLabelChars = axis.maxLabelChars;
		this.typeface = axis.typeface;
		this.formatter = axis.formatter;

		for (AxisValue axisValue : values) {
			this.values.add(new AxisValue(axisValue));
		}
	}

	public List<AxisValue> getValues() {
		return values;
	}

	/**
	 * If values is null or empty array axis will be auto-generated, otherwise values will be used to draw axis.
	 */
	public Axis setValues(List<AxisValue> values) {
		if (null == values || values.isEmpty()) {
			values = new ArrayList<AxisValue>();
			this.isAutoGenerated = true;
		} else {
			this.values = values;
			this.isAutoGenerated = false;
		}
		return this;
	}

	public String getName() {
		return name;
	}

	public Axis setName(String name) {
		this.name = name;
		return this;
	}

	public boolean isAutoGenerated() {
		return isAutoGenerated;
	}

	public Axis setAutoGenerated(boolean isAutoGenerated) {
		this.isAutoGenerated = isAutoGenerated;
		return this;
	}

	public boolean hasLines() {
		return hasLines;
	}

	public Axis setHasLines(boolean hasLines) {
		this.hasLines = hasLines;
		return this;
	}

	public int getTextColor() {
		return textColor;
	}

	public Axis setTextColor(int color) {
		this.textColor = color;
		return this;
	}

	public int getLineColor() {
		return lineColor;
	}

	public Axis setLineColor(int lineColor) {
		this.lineColor = lineColor;
		return this;
	}

	public int getTextSize() {
		return textSize;
	}

	public Axis setTextSize(int textSize) {
		this.textSize = textSize;
		return this;
	}

	public int getMaxLabelChars() {
		return maxLabelChars;
	}

	/**
	 * Set maximum number of characters for axis labels, min 0, max 32.
	 */
	public Axis setMaxLabelChars(int maxLabelChars) {
		if (maxLabelChars < 0) {
			maxLabelChars = 0;
		} else if (maxLabelChars > 32) {
			maxLabelChars = 32;
		}
		this.maxLabelChars = maxLabelChars;
		return this;
	}

	public Typeface getTypeface() {
		return typeface;
	}

	public Axis setTypeface(Typeface typeface) {
		this.typeface = typeface;
		return this;
	}

	public ValueFormatter getFormatter() {
		return formatter;
	}

	public Axis setFormatter(ValueFormatter formatter) {
		if (null == formatter) {
			this.formatter = new SimpleValueFormatter();
		} else {
			this.formatter = formatter;
		}
		return this;
	}
}
