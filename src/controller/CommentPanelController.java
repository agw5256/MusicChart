package controller;

import DB.ConnectDB;
import main.AppManager;
import model.ChartData;
import org.json.simple.JSONObject;
import view.CommentPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Desktop;
import java.net.URLEncoder;

public class CommentPanelController {
    ConnectDB DB = new ConnectDB();

    private final CommentPanel the_Comment_Panel;

    public CommentPanelController(CommentPanel theCommentPanel) {
        this.the_Comment_Panel = theCommentPanel;
        this.the_Comment_Panel.addBtnRegisterListener(new ButtonRegisterListener());
        this.the_Comment_Panel.addBtnDeleteListener(new ButtonDeleteListener());
        this.the_Comment_Panel.addBtnBackListener(new ButtonBackListener());
        this.the_Comment_Panel.addBtnYouTubeListener(new ButtonYouTubeListener());
    }

    private class ButtonRegisterListener implements ActionListener{
        private Component view_Loading;
        public ButtonRegisterListener() { }
        public ButtonRegisterListener(Component parentComponent){
            view_Loading = parentComponent;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!the_Comment_Panel._txtComment.getText().equals("")) {
                DB.insertDB(the_Comment_Panel._sqlTitle,
                        the_Comment_Panel._strArtist,
                        ChartData.getS_instance().getParser().getAlbumName(the_Comment_Panel.getCommentPanelRank()),
                        ChartData.getS_instance().getSite_M_B_G(),
                        the_Comment_Panel._txtComment.getText(),
                        the_Comment_Panel._txtPassword.getText());

                the_Comment_Panel._modelList.addElement(the_Comment_Panel._txtComment.getText());
                the_Comment_Panel._arrComment.add(the_Comment_Panel._txtComment.getText());

                if (the_Comment_Panel._txtPassword.getText().equals(""))
                    the_Comment_Panel._arrPassword.add("0000");
                else
                    the_Comment_Panel._arrPassword.add(the_Comment_Panel._txtPassword.getText());

                the_Comment_Panel.clearPanelTxt();
            }//obj == btnRegister
        }//actionPerformed
    }//ButtonRegisterListener

    private class ButtonDeleteListener implements ActionListener{
        private Component view_Loading;
        public ButtonDeleteListener() { }
        public ButtonDeleteListener(Component parentComponent){
            view_Loading = parentComponent;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (Integer.parseInt(the_Comment_Panel._txtPassword.getText()) == Integer.parseInt(the_Comment_Panel._arrPassword.get(the_Comment_Panel._listComment.getSelectedIndex()))) {
                System.out.println("Same Password! At : " + String.valueOf(the_Comment_Panel._listComment.getSelectedIndex()));
                DB.deleteDB(the_Comment_Panel._sqlTitle, the_Comment_Panel._txtPassword.getText());
                
                the_Comment_Panel._arrPassword.remove(the_Comment_Panel._listComment.getSelectedIndex());
                the_Comment_Panel._arrComment.remove(the_Comment_Panel._listComment.getSelectedIndex());
                the_Comment_Panel._modelList.removeElementAt(the_Comment_Panel._listComment.getSelectedIndex());
            }
            the_Comment_Panel._txtPassword.setText("");
        }//actionPerformed
    }//ButtonDeleteListener

    private class ButtonBackListener implements ActionListener{
        private Component view_Loading;
        public ButtonBackListener() { }
        public ButtonBackListener(Component parentComponent){
            view_Loading = parentComponent;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            the_Comment_Panel.clearMusicData();
            BackToChartPrimaryPanel();
            System.out.println("Back To ChartPrimary");
        }//actionPerformed
    }//ButtonBackListener

    private class ButtonYouTubeListener implements ActionListener{
        private Component view_Loading;
        public ButtonYouTubeListener() { }
        public ButtonYouTubeListener(Component parentComponent){
            view_Loading = parentComponent;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Desktop.getDesktop().browse(new URI("https://www.youtube.com/results?search_query=" + URLEncoder.encode(the_Comment_Panel._strTitle, "UTF-8")));
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (URISyntaxException ex) {
                ex.printStackTrace();
            }
            System.out.println("Search in Youtube");
        }//actionPerformed
    }//ButtonYoutubeListener

    public void BackToChartPrimaryPanel(){
        AppManager.getS_instance().getPrimaryPanel().repaint();
        AppManager.getS_instance().getPnlCommentPanel().setVisible(false);
        AppManager.getS_instance().getChartPrimaryPanel().setVisible(true);
    }
}
