package day0608.io;
import java.io.*;

public class StreamTokenizerEx {
	public static void main(String[] args) {
		BufferedReader br = null;
		StreamTokenizer st = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter("d://streamToken.txt");
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw,true);
			pw.println(10000);
			pw.println("안녕하세요");
			pw.println("nals@lycos.co.kr");
			pw.println("I am a Gentleman");
			pw.println("~`@!#");
			
			br = new BufferedReader(new FileReader("d://streamToken.txt")); //파일로부터 데이터 얻어옴
			st = new StreamTokenizer(br);//스트림토커나이저에게 넘겨줌
			while(st.nextToken() != StreamTokenizer.TT_EOF) { //TT_EOF: 마지막데이터가 아니라면 ->읽어온데이터가 있으면,
				switch(st.ttype) {
				case StreamTokenizer.TT_WORD:
					System.out.println("Word => " + st.sval);
					break;
				case StreamTokenizer.TT_NUMBER:
					System.out.println("Number => " + (int)st.nval);
					break;
				default:
					System.out.println("No word,No number => " + (char)st.ttype);
					break;
				}
			}
			
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}finally {
			try {
				if(fw!=null) fw.close();
				if (bw != null)	bw.close();
				if (pw != null)	pw.close();
				if (br != null)	br.close();
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}
