/*
 * Copyright (c) 2018. Alex Vozisov (vozisov@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.vozisov.base64;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Controller {

    public Button encodego, decodego;
    @FXML
    private TextArea encodein, encodeout, decodein, decodeout;

    @FXML
    public void clickEn(ActionEvent actionEvent) {
        encodeout.setText(encodeString(encodein.getText()));
    }

    @FXML
    public void clickDe(ActionEvent actionEvent) {
        decodeout.setText(decodeString(decodein.getText()));
    }

    private static String encodeString(String s) {
        byte[] data = new byte[0];

        try {
            data = s.getBytes("UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            String base64Encoded = Base64.getEncoder().encodeToString(data);
            return base64Encoded;

        }
    }

    private static String decodeString(String encoded) {
        byte[] dataDec = Base64.getDecoder().decode(encoded);
        String decodedString = "";
        try {

            decodedString = new String(dataDec, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();

        } finally {

            return decodedString;
        }
    }
}
