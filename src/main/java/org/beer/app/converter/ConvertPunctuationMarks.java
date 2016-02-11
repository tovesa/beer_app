package org.beer.app.converter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConvertPunctuationMarks {

	public static String formatPunctuationMarks(String line) {
		String formattedLine = line;
		formattedLine = addDotAfterDate(formattedLine);
		formattedLine = addDotAfterScore(formattedLine);
		formattedLine = changeCommasToDots(formattedLine);
		return formattedLine;
	}

	public static String changeCommasToDots(String line) {
		String formattedLine;
		formattedLine = line.replaceAll("cl ", "cl. ");
		formattedLine = formattedLine.replaceAll("cl,", "cl.");
		formattedLine = formattedLine.replaceAll("ml ", "ml. ");
		formattedLine = formattedLine.replaceAll("ml,", "ml.");
		formattedLine = formattedLine.replaceAll("Pirkkala,", "Pirkkala.");
		formattedLine = formattedLine.replaceAll("Ruovesi,", "Ruovesi.");
		formattedLine = formattedLine.replaceAll("Ruovesi,", "Ruovesi.");
		formattedLine = formattedLine.replaceAll("\\.,", ".");
		formattedLine = formattedLine.replaceAll(",\\.", ".");
		formattedLine = formattedLine.replaceAll("\\.\\.", ".");
		StringBuffer sb = new StringBuffer();
		sb.append(formattedLine);
		return sb.toString();
	}

	private static String addDotAfterDate(String line) {
		Pattern p = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
		Matcher m = p.matcher(line);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			String text = m.group();
			StringBuffer formattedDate = new StringBuffer();
			formattedDate.append(text);
			formattedDate.append(".");
			m.appendReplacement(sb, formattedDate.toString());
		}
		m.appendTail(sb);
		String ret = sb.toString().replaceFirst("\\s+$", "");
		return ret;
	}

	private static String addDotAfterScore(String line) {
		Pattern p = Pattern.compile("\\d{6}");
		Matcher m = p.matcher(line);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			String text = m.group();
			StringBuffer formattedScore = new StringBuffer();
			formattedScore.append(text);
			formattedScore.append(".");
			m.appendReplacement(sb, formattedScore.toString());
		}
		m.appendTail(sb);
		String ret = sb.toString().replaceFirst("\\s+$", "");
		return ret;
	}
}
