package view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class SiteChartsPanel extends JPanel{
    public ChartPanel pnlChartPanel;
    private JButton btnRefresh, btnSite_Melon, btnSite_Bugs, btnSite_Genie, btnSearch;
    public JLabel lblTime;
    public JComboBox<String> strCombo;

    public JTextField txtSearch;

    public String formatted_Melon = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    public String formatted_Bugs = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    public String formatted_Genie = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    //refreshTime


    public SiteChartsPanel(){

        setBackground(new Color(255, 255, 255, 0));
        setBounds(1,0,1278,960);
        setLayout(null);

        setInitBtnRefresh();

        setInitStrCombo();

        setInitBtnSearch();

        setInitTextSearch();

        setInitPnlChartPanel();

        setInitBtnSites();

        setInitLblTime();

    }//constructor

    private void setInitBtnRefresh(){
        btnRefresh = new JButton(new ImageIcon("Image/Refresh.png"));
        btnRefresh.setBounds(30,30,40,40);
        btnRefresh.setForeground(Color.DARK_GRAY);
        btnRefresh.setBackground(Color.lightGray);
        this.add(btnRefresh);
    }

    private void setInitBtnSearch(){
        btnSearch = new JButton("Search");
        btnSearch.setBounds(1090,30,150,40);
        btnSearch.setForeground(Color.DARK_GRAY);
        btnSearch.setBackground(Color.lightGray);
        this.add(btnSearch);
    }

    private void setInitStrCombo(){
        strCombo = new JComboBox<String>(new String[]{"Name","Artist"});
        strCombo.setBounds(100, 30, 150,40);
        strCombo.setEditable(false);
        this.add(strCombo);
    }

    private void setInitTextSearch(){
        txtSearch = new JTextField();
        txtSearch.setBounds(250,30,840,40);
        txtSearch.setFont(new Font("SansSerif", Font.PLAIN, 25));
        this.add(txtSearch);
    }

    private void setInitBtnSites(){
        btnSite_Melon = new JButton(new ImageIcon("Image/logo_Melon.png"));
        btnSite_Melon.setBounds(100,100,150,40);
        btnSite_Melon.setBackground(Color.WHITE);
        this.add(btnSite_Melon);

        btnSite_Bugs = new JButton(new ImageIcon("Image/logo_Bugs.png"));
        btnSite_Bugs.setBounds(250,100,150,40);
        btnSite_Bugs.setBackground(Color.WHITE);
        this.add(btnSite_Bugs);

        btnSite_Genie = new JButton(new ImageIcon("Image/logo_Genie.png"));
        btnSite_Genie.setBounds(400,100,150,40);
        btnSite_Genie.setBackground(Color.WHITE);
        this.add(btnSite_Genie);
    }

    private void setInitPnlChartPanel(){
        pnlChartPanel = new ChartPanel();
        pnlChartPanel.setBounds(100,140,1080,700);
        LineBorder SiteBorder = new LineBorder(Color.BLACK,3);
        pnlChartPanel.setBorder(SiteBorder);
        pnlChartPanel.setLayout(null);
        this.add(pnlChartPanel);
    }

    private void setInitLblTime(){
        lblTime = new JLabel("Renewal time : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));

        lblTime.setBounds(900,870,200,40);
        lblTime.setFont(new Font("Verdana", Font.BOLD + Font.PLAIN, 14));
        lblTime.setBackground(Color.lightGray);
        lblTime.setHorizontalAlignment(SwingConstants.CENTER);
        lblTime.setOpaque(true);
        this.add(lblTime);
    }

    public void addBtnRefreshListener(ActionListener listenForBtnRefresh) {
        btnRefresh.addActionListener((listenForBtnRefresh));
    }

    public void addBtnMelonListener(ActionListener listenForBtnMelon) {
        btnSite_Melon.addActionListener((listenForBtnMelon));
    }

    public void addBtnBugsListener(ActionListener listenForBtnBugs) {
        btnSite_Bugs.addActionListener((listenForBtnBugs));
    }

    public void addBtnGenieListener(ActionListener listenForBtnGenie) {
        btnSite_Genie.addActionListener((listenForBtnGenie));
    }

    public void addKeyActionListener(KeyListener listenForKey) {
        txtSearch.addKeyListener((listenForKey));
    }


}