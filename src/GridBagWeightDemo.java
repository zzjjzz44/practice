import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;

public class GridBagWeightDemo extends JFrame {
    JPanel mainPanel = new JPanel(new GridBagLayout());
    // 创建 GridBagConstraints 对象
    GridBagConstraints gbc = new GridBagConstraints();
    public GridBagWeightDemo() {
        super("GridBagLayout 权重设置示例");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        gbc.fill = GridBagConstraints.BOTH; // 组件在水平和垂直方向都填满分配的空间
        gbc.insets = new Insets(5, 5, 5, 5); // 设置组件之间的间距

        // 示例1：默认权重（都为0）
        JButton button1 = new JButton("按钮1 ");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0;  // 默认值
       gbc.weighty = 0.0;  // 默认值
        mainPanel.add(button1, gbc);
        button1.addActionListener(e ->{
            System.out.println("按钮1被点击了！");
            diji();}
        );

        // 示例2：水平权重为1，垂直权重为0
        JButton button2 = new JButton("按钮2 ");
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weightx = 1.0;  // 水平方向占据额外空间
        gbc.weighty = 1.0;  // 垂直方向不扩展
        mainPanel.add(button2, gbc);



        add(mainPanel);
        // 设置窗口属性
        setSize(600, 400);
        setLocationRelativeTo(null); // 居中显示
        setVisible(true);

    }
        void diji() {
            JButton button5 = new JButton("可以");
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.weightx = 1.0;  // 水平方向占据额外空间
            gbc.weighty = 1.0;// 垂直方向占
            gbc.fill = GridBagConstraints.BOTH; // 组件在水平和垂直方向都填满分配的空间
            mainPanel.add(button5, gbc);
            revalidate(); // 重新验证布局
            repaint(); // 重绘窗口
        }

    public static void main(String[] args) {
        // 在事件调度线程中创建GUI
        SwingUtilities.invokeLater(() -> {
            new GridBagWeightDemo();
        });
    }
}
