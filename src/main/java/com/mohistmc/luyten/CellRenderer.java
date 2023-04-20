package com.mohistmc.luyten;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.Component;
import java.awt.Toolkit;

public class CellRenderer extends DefaultTreeCellRenderer {
    private static final long serialVersionUID = -5691181006363313993L;
    Icon pack;
    Icon classIcon;
    Icon htmlIcon;
    Icon cssIcon;
    Icon textIcon;
    Icon imageIcon;
    Icon fileIcon;

    public CellRenderer() {
        this.pack = new ImageIcon(
                Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/package_obj.png")));
        this.classIcon = new ImageIcon(
                Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/java.png")));
        this.htmlIcon = new ImageIcon(
                Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/html.png")));
        this.cssIcon = new ImageIcon(
                Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/css.png")));
        this.textIcon = new ImageIcon(
                Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/yml.png")));
        this.imageIcon = new ImageIcon(
                Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/image.png")));
        this.fileIcon = new ImageIcon(
                Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/file.png")));
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
                                                  int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        if (node.getChildCount() > 0) {
            setIcon(this.pack);
        } else if (getFileName(node).endsWith(".class") || getFileName(node).endsWith(".java")) {
            setIcon(this.classIcon);
        } else if (getFileName(node).endsWith(".yml") || getFileName(node).endsWith(".yaml")) {
            setIcon(this.textIcon);
        } else if (getFileName(node).endsWith(".html") || getFileName(node).endsWith(".htm")) {
            setIcon(this.htmlIcon);
        } else if (getFileName(node).endsWith(".css")) {
            setIcon(this.cssIcon);
        } else if (getFileName(node).endsWith(".png") || getFileName(node).endsWith(".jpg") || getFileName(node).endsWith(".jpeg") || getFileName(node).endsWith(".gif") || getFileName(node).endsWith(".svg")) {
            setIcon(this.imageIcon);
        } else {
            setIcon(this.fileIcon);
        }
        putClientProperty("html.disable", true);
        return this;
    }

    public String getFileName(DefaultMutableTreeNode node) {
        return ((TreeNodeUserObject) node.getUserObject()).getOriginalName();
    }

}
