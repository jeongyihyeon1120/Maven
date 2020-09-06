package eunjeon;

import org.bitbucket.eunjeon.seunjeon.Analyzer;
import org.bitbucket.eunjeon.seunjeon.Eojeol;
import org.bitbucket.eunjeon.seunjeon.LNode;
import org.bitbucket.eunjeon.seunjeon.Morpheme;

public class Test {
	public static void main(String args[]) {
//		for (LNode node : Analyzer.parseJava("아버지가방에들어가신다.")) {
//            System.out.println(node);
//        }
//		for (Eojeol eojeol: Analyzer.parseEojeolJava("아버지가방에들어가신다. 안녕하세요.")) {
//            System.out.println(eojeol);
//            for (LNode node: eojeol.nodesJava()) {
//                System.out.println(node);
//            }
//        }
		for (LNode node :  Analyzer.parseJava("아버지가방에들어가신다. 안녕하세요.")) {
			Morpheme m = node.morpheme();
			System.out.println(m.surface() + " / 품사: " + m.feature().head());
		}
	}
}
