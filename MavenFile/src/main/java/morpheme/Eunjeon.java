package morpheme;

import org.openkoreantext.processor.OpenKoreanTextProcessorJava;
import org.openkoreantext.processor.phrase_extractor.KoreanPhraseExtractor;
import org.openkoreantext.processor.tokenizer.KoreanTokenizer;
import scala.collection.Seq;

public class Eunjeon {

	public static void main(String[] args) {
		
		 String text = "한국어를 처리하는 예시입니닼ㅋㅋㅋㅋㅋ #한국어";
		 CharSequence normalized = OpenKoreanTextProcessorJava.normalize(text);
		 System.out.println(normalized);
		 Seq<KoreanTokenizer.KoreanToken> tokens = OpenKoreanTextProcessorJava.tokenize(normalized);
		 System.out.println(OpenKoreanTextProcessorJava.tokensToJavaStringList(tokens));
		 System.out.println(OpenKoreanTextProcessorJava.tokensToJavaKoreanTokenList(tokens));
        
    }
}
