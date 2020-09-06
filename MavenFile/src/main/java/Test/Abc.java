package Test;

import java.util.ArrayList;

import org.bitbucket.eunjeon.seunjeon.Analyzer;
import org.bitbucket.eunjeon.seunjeon.LNode;
import org.bitbucket.eunjeon.seunjeon.Morpheme;

public class Abc {
	
	public static void main(String[] args) {
		for (LNode node :  Analyzer.parseJava("아버지가방에들어가신다.")) {
			Morpheme m = node.morpheme();
			System.out.println(m.surface() + " / 품사: " + m.feature().head());
			if(m.feature().head().equals("NNG")) {
				System.out.println("true");
			}
		}
	}
}
