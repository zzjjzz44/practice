import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class jisuan extends JFrame {
    JPanel m = new JPanel(new BorderLayout());
    JPanel m1 = new JPanel();
    JTextField t1 = new JTextField(20);

    public jisuan() {
        super("计算器");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        this.add(m, BorderLayout.NORTH);
        this.add(m1, BorderLayout.CENTER);

        m1.setLayout(new GridLayout(4, 4));

        t1.setFont(new Font("微软雅黑", Font.PLAIN, 48));
        t1.setHorizontalAlignment(JTextField.RIGHT);
        t1.setText("0");
        m.add(t1);

        ActionListener commonListener = e -> {
            JButton source = (JButton) e.getSource();
            String cmd = source.getText();
            if (cmd.equals("del")) {
                t1.setText("0");
            } else if (cmd.equals("=")) {
                    String a = t1.getText();
                    //System.out.println(a);
                    int k=0;
                    int num = 0;
                    char[] jsf=new char[10];
                    int j=0;
                    int num1 = 0;
                    int sy=0;
                    for(int i=0;i<a.length();i++) {
                        char c = a.charAt(i);
                        //System.out.println(c);
                        if (c >= '0' && c <= '9'&&i!=a.length()-1) {
                            if(a.charAt(i+1)<'0' || a.charAt(i+1)>'9') {
                                num1 = Integer.parseInt(a.substring(k, i + 1).trim());
                                //System.out.println(num1);
                                k = i + 2;
                            }
                        }
                        else if(i==a.length()-1) {
                            num1 = Integer.parseInt(a.substring(k).trim());
                        }

                        if(num==0) {num=num1;num1=0;}

                        if(c=='+'||c=='-'||c=='x'||c=='/')
                        {   jsf[j]= c;
                            //System.out.println(++sy);
                            k=i+1;}

                        if(jsf[j]!=0&&num!=0&&num1!=0)
                        {//System.out.println(++sy);
                            if (jsf[j] == '+') {
                                num = num + num1;
                                //System.out.println(++sy);
                                //System.out.println(num1);
                               //System.out.println(num);
                                j++;
                            } else if (jsf[j] == '-') {
                                num = num - num1;
                                j++;
                            } else if (jsf[j] == 'x') {
                                num = num * num1;
                                j++;
                            } else if (jsf[j]  == '/') {
                                if (num1 == 0) {
                                    t1.setText("Error");
                                    return;}
                                num = num1 / num;
                                j++;
                            }
                        }
                    }
                String numStr  = String.valueOf(num);
                //System.out.println(num);
                t1.setText(numStr);
                    }

            else if(cmd.equals("+") || cmd.equals("-") || cmd.equals("x") || cmd.equals("/")){
                if (t1.getText().equals("0") || t1.getText().equals("Error")) {
                    t1.setText("0");
                } else {
                    t1.setText(t1.getText() + " " + cmd + " ");
                }
            }

            else {
                if (t1.getText().equals("0") || t1.getText().equals("Error")||t1.getText().equals("=")) {
                    t1.setText(cmd);
                } else {
                    t1.setText(t1.getText() + cmd);
                }
            }

        };


        Font bt = new Font("微软雅黑", Font.PLAIN, 24);
        JButton j1 = createButton("1", bt);
        j1.addActionListener(commonListener);
        JButton j2 =  createButton("2", bt);
        j2.addActionListener(commonListener);
        JButton j3 =  createButton("3", bt);
        j3.addActionListener(commonListener);
        JButton j4 =  createButton("4", bt);
        j4.addActionListener(commonListener);
        JButton j5 =  createButton("5", bt);
        j5.addActionListener(commonListener);
        JButton j6 =  createButton("6", bt);
        j6.addActionListener(commonListener);
        JButton j7 =  createButton("7", bt);
        j7.addActionListener(commonListener);
        JButton j8 =  createButton("8", bt);
        j8.addActionListener(commonListener);
        JButton j9 =  createButton("9", bt);
        j9.addActionListener(commonListener);
        JButton j0 =  createButton("0", bt);
        j0.addActionListener(commonListener);
        JButton jia =  createButton("+", bt);
        jia.addActionListener(commonListener);
        JButton jian = createButton("-", bt);
        jian.addActionListener(commonListener);
        JButton cheng =createButton("x", bt);
        cheng.addActionListener(commonListener);
        JButton chu =  createButton("/", bt);
        chu.addActionListener(commonListener);
        JButton dengyu =  createButton("=", bt);
        dengyu.addActionListener(commonListener);
        JButton qingchu =  createButton("del", bt);
        qingchu.addActionListener(commonListener);
        m1.add(j1);
        m1.add(j2);
        m1.add(j3);
        m1.add(j4);
        m1.add(j5);
        m1.add(j6);
        m1.add(j7);
        m1.add(j8);
        m1.add(j9);
        m1.add(j0);
        m1.add(jia);
        m1.add(jian);
        m1.add(cheng);
        m1.add(chu);
        m1.add(dengyu);
        m1.add(qingchu);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setVisible(true);
    }

     JButton createButton(String text, Font bt) {
        JButton button = new JButton(text);
        button.setFont(bt);

        return button;
    }


    public static void main(String[] args) {
        new jisuan();
}
}
