import java.awt.*; 
import java.awt.event.*;  

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;

import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.*; 
import java.util.Date;
import java.util.Scanner;  
import java.io.*;  
import java.awt.Font;
import javax.swing.JTextArea;
 
public class notepad1 extends JFrame implements ActionListener
{
JFrame f=new JFrame();	
JMenuBar mb;
JMenu file,edit,format,view,help,font;
JMenuItem open,neww,td,save,print,exit,cut,copy,paste,font1,replace,sall,del,ww,italic,bold,bg,sb,vw,an;  
JTextArea ta;  
Container c;

notepad1(){  
	this.setSize(500, 300); 
	
	ta=new JTextArea(800,800);  
	ta.setBounds(0,20,800,800);  
	
	ta.setFont(new Font("Arial", Font.BOLD, 12)); 
	this.getContentPane().setLayout(new BorderLayout()); 
	 c=getContentPane();
	this.getContentPane().add(ta);
	
neww=new JMenuItem("New");
open=new JMenuItem("Open");
save=new JMenuItem("Save");
print=new JMenuItem("Print");
exit=new JMenuItem("Exit");
cut=new JMenuItem("Cut");
copy=new JMenuItem("Copy");
paste=new JMenuItem("Paste");
//font1=new JMenuItem("Font1");
//replace=new JMenuItem("Replace");
sall=new JMenuItem("Select All");
del=new JMenuItem("Delete");
td=new JMenuItem("Time And Date");
ww=new JMenuItem("WordWrap");
italic=new JMenuItem("ITALICS");
bold=new JMenuItem("BOLD");
bg=new JMenuItem("Backgroundchosser");
sb=new JMenuItem("Status Bar");
an=new JMenuItem("About Notepad");

file=new JMenu("File");
edit=new JMenu("Edit");
font=new JMenu("Font");
format=new JMenu("Format");
view=new JMenu("View");
help=new JMenu("Help");
file.setMnemonic('F');

file.add(neww);  
file.add(open);
file.add(save);
file.add(print);
file.add(exit);
edit.add(cut);
edit.add(copy);
edit.add(paste);
//font.add(font1);
//edit.add(replace);
edit.add(sall);
edit.add(del);
edit.add(td);
format.add(ww);
format.add(font);
font.add(italic);
font.add(bold);
format.add(bg);
view.add(sb);
help.add(an);

mb=new JMenuBar();  
mb.setBounds(0,0,800,20);  
mb.add(file);  
mb.add(edit);          
mb.add(format);          
mb.add(view);          
mb.add(help);          
add(mb);  
//neww.setAccelerator(KeyStroke.getKeyStroke('N',CTRL_DOWN_MASK));
//setting shortcuts
file.setMnemonic(KeyEvent.VK_F);
edit.setMnemonic(KeyEvent.VK_E);
format.setMnemonic(KeyEvent.VK_G);
help.setMnemonic(KeyEvent.VK_H);
view.setMnemonic(KeyEvent.VK_C);

KeyStroke opn=KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK);
open.setAccelerator(opn);
KeyStroke n=KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK);
neww.setAccelerator(n);
KeyStroke sa=KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK);
save.setAccelerator(sa);
KeyStroke cl=KeyStroke.getKeyStroke(KeyEvent.VK_W,KeyEvent.CTRL_DOWN_MASK);
exit.setAccelerator(cl);
KeyStroke pr=KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_DOWN_MASK);
print.setAccelerator(pr);
KeyStroke cutt=KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_DOWN_MASK);
cut.setAccelerator(cutt);
KeyStroke co=KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_DOWN_MASK);
copy.setAccelerator(co);
KeyStroke pa=KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_DOWN_MASK);
paste.setAccelerator(pa);
KeyStroke saa=KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_DOWN_MASK);
sall.setAccelerator(saa);
KeyStroke de=KeyStroke.getKeyStroke(KeyEvent.VK_D,KeyEvent.CTRL_DOWN_MASK);
del.setAccelerator(de);
KeyStroke fi=KeyStroke.getKeyStroke(KeyEvent.VK_F,KeyEvent.CTRL_DOWN_MASK);
/*find.setAccelerator(fi);
KeyStroke re=KeyStroke.getKeyStroke(KeyEvent.VK_R,KeyEvent.CTRL_DOWN_MASK);
replace.setAccelerator(re);*/
KeyStroke w=KeyStroke.getKeyStroke(KeyEvent.VK_Y,KeyEvent.CTRL_DOWN_MASK);
ww.setAccelerator(w);
KeyStroke i=KeyStroke.getKeyStroke(KeyEvent.VK_I,KeyEvent.CTRL_DOWN_MASK);
italic.setAccelerator(i);
KeyStroke b=KeyStroke.getKeyStroke(KeyEvent.VK_B,KeyEvent.CTRL_DOWN_MASK);
bold.setAccelerator(b);
KeyStroke da=KeyStroke.getKeyStroke(KeyEvent.VK_T,KeyEvent.CTRL_DOWN_MASK);
td.setAccelerator(da);
KeyStroke bgg=KeyStroke.getKeyStroke(KeyEvent.VK_G,KeyEvent.CTRL_DOWN_MASK);
bg.setAccelerator(bgg);
KeyStroke sbar=KeyStroke.getKeyStroke(KeyEvent.VK_Q,KeyEvent.CTRL_DOWN_MASK);
an.setAccelerator(sbar);

neww.addActionListener(this);
open.addActionListener(this);  
save.addActionListener(this);  
print.addActionListener(this);  
exit.addActionListener(this);
cut.addActionListener(this);  
copy.addActionListener(this);  
paste.addActionListener(this);  
sall.addActionListener(this);  
del.addActionListener(this);  
td.addActionListener(this);

ww.addActionListener(this);
italic.addActionListener(this);  
bold.addActionListener(this);  
bg.addActionListener(this);  

sb.addActionListener(this);

an.addActionListener(this);
}  



public void actionPerformed(ActionEvent e)
{  
		if(e.getSource()==neww)
		{
			JOptionPane jp=new JOptionPane();
			Object[] options={"Save","Don't Save","Cancel"};
			int button=jp.showOptionDialog(null,"Do you want to save changes.."
					+getTitle(),"  Notepad",
					JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,
					null,options,options[0]);
			if(button==0)
			{
				savefile();
			}
			else if(button==1)
			{
				ta.setText(" ");
			}
			else
			{
	   
			}
			}
			else if(e.getSource()==open)
			{  	
			openFile();
			}
			
	 		else if(e.getSource()==this.cut)
			ta.cut();
			else if(e.getSource()==this.copy)
			ta.copy();
			else if(e.getSource()==this.paste)
				ta.paste();
			else if(e.getSource()==this.sall)
				ta.selectAll();
			else if(e.getSource()==this.del)
				ta.replaceSelection("");
			else if(e.getSource()==this.td)
				 ta.insert(new Date().toString(),ta.getSelectionStart());
			else if(e.getSource()==save)
              {
             	savefile();
              }
			else if(e.getSource()==sb)
			{    setLayout(new BorderLayout());
			Panel p=new Panel();
			add(p,BorderLayout.SOUTH);
						p.add(new JLabel("Status Frame 1.0"));
			}  
			
			else if(e.getSource()==print)
				JOptionPane.showMessageDialog(  
					    notepad1.this.f,  
					    "YOU ARE NOTCONNECTED TO A PRINTER",  
					    "Bad Printer",  
					    JOptionPane.INFORMATION_MESSAGE  
					    );  
           	 else if(e.getSource()==bg) 
           	 {
           		Color initialcolor=Color.RED;  
           		Color color=JColorChooser.showDialog(this,"Select a color",initialcolor);  
           		c.setBackground(color);  
           	 }
           	 else if(e.getSource()==exit)
           	 {JOptionPane jp=new JOptionPane();
 			Object[] options={"Save and Exit","Don't Save and Exit","Cancel"};
 			int button=jp.showOptionDialog(null,"ARE YOU SURE YOU WANT TO EXIT.."
 					+getTitle(),"",
 					JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,
 					null,options,options[0]);
 			if(button==0)
 			{
 				savefile();
 				System.exit(0);
 			}
 			else if(button==1)
 			{
 				System.exit(0);
 			}
 			else
 			{
 	   
 			}
	   	}
           	//  new Exit_Window().setVisible(true);
   	else if(e.getSource()==ww) {
                ta.setLineWrap(true);
                ta.setWrapStyleWord(true);
                
            	}
           	
           	else if(e.getSource()==italic) {
                ta.setFont(new Font("Italic", Font.ITALIC, 12));
           	}


           	else if(e.getSource()==bold) {
            ta.setFont(new Font("Monotype Corsiva", Font.BOLD, 12));
           
           	}	
			
        	/*else if(e.getSource()==font1) {
        		 Font current=ta.getFont();
        		 JFontChooser dialog=new JFontChooser(null);
        		 dialog.setFont(current);
        		 int ret=dialog.showDialog();
        		 
        		 if(ret==dialog.OK_OPTION){
        			 ta.setFont(dialog.getFont());
        			
               	}
        	}*/
        	else if(e.getSource()==an)
            {
        		JOptionPane jp=new JOptionPane();
        		jp.showMessageDialog(null,"#_MICROSOFT WINDOWS....Created by ayushi garg...");
            }
    			
}  

void savefile()
{
	JFileChooser save=new JFileChooser();
	save.setDialogTitle("Specify a file to save");
	int i=save.showSaveDialog(this);
	if(i == JFileChooser.APPROVE_OPTION)
	{
		try{
			BufferedWriter out=new BufferedWriter(new FileWriter(save.getSelectedFile().getPath()));
			out.write(ta.getText());
			out.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
				}
	 
  }
	
}

   
	
void openFile(){  
JFileChooser fc=new JFileChooser();  
int i=fc.showOpenDialog(this);  
          
if(i==JFileChooser.APPROVE_OPTION){  
File f=fc.getSelectedFile();  
String filepath=f.getPath();                
displayContent(filepath);  
}  
          
}  
  
void displayContent(String fpath){  
try{  
BufferedReader br=new BufferedReader(new FileReader(fpath));  
String s1="",s2="";  
              
while((s1=br.readLine())!=null){  
s2+=s1+"\n";  
}  
ta.setText(s2);  
br.close();  
}catch (Exception e) {e.printStackTrace();  }  
}  
  
public static void main(String[] args) {  
	
    notepad1 np=new notepad1();  
    np.setTitle("NOTEPAD");
    np.setLayout(null);  
    np.setVisible(true);  
    np.setDefaultCloseOperation(EXIT_ON_CLOSE);  
}  
}  
