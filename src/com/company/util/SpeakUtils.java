package com.company.util;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

/**
 * @Title:
 * @Package
 * @Description:
 * @Author gyf
 * @Date 2020/6/18 19:41
 */
public class SpeakUtils {
    public static void speak(String value) {
        // ？？ 这个Sapi.SpVoice是需要安装什么东西吗，感觉平白无故就来了
        ActiveXComponent sap = new ActiveXComponent("Sapi.SpVoice");
        // Dispatch是做什么的？
        Dispatch sapo = (Dispatch) sap.getObject();
        try {

            // 音量 0-100
            sap.setProperty("Volume", new Variant(100));
            // 语音朗读速度 -10 到 +10
            sap.setProperty("Rate", new Variant(-2));

            Variant defalutVoice = sap.getProperty("Voice");

            Dispatch dispdefaultVoice = (Dispatch) defalutVoice.toDispatch();
            Variant allVoices = Dispatch.call(sapo, "GetVoices");
            Dispatch dispVoices = (Dispatch) allVoices.toDispatch();

            Dispatch setvoice = Dispatch.call(dispVoices, "Item", new Variant(1)).toDispatch();
            ActiveXComponent voiceActivex = new ActiveXComponent(dispdefaultVoice);
            ActiveXComponent setvoiceActivex = new ActiveXComponent(setvoice);

            Variant item = Dispatch.call(setvoiceActivex, "GetDescription");
            // 执行朗读
            Dispatch.call(sapo, "Speak", new Variant(value));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sapo.safeRelease();
            sap.safeRelease();
        }
    }
}
