package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;



public class TagMensagem  extends SimpleTagSupport{
	private String mensagem="";

	public String getMensagem() {
		return this.mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
@Override
public void doTag() throws JspException, IOException {
	PageContext pc= (PageContext) getJspContext();
	JspWriter out= pc.getOut();
	StringBuffer sb = new StringBuffer();
		if(mensagem.length()!=0){
			sb.append("<div class='alert alert-info'>");
			sb.append(mensagem);
			sb.append("</div>");
		}else{
			sb.append("");
		}
		System.out.println("mensagem tag " + sb.toString());	
		out.print(sb.toString());
}
}
