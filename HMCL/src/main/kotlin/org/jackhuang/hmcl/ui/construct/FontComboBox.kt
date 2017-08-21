/*
 * Hello Minecraft! Launcher.
 * Copyright (C) 2017  huangyuhui <huanghongxun2008@126.com>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see {http://www.gnu.org/licenses/}.
 */
package org.jackhuang.hmcl.ui.construct

import com.jfoenix.controls.JFXComboBox
import javafx.beans.NamedArg
import javafx.collections.FXCollections
import javafx.scene.control.ListCell
import javafx.scene.text.Font
import javafx.util.Callback

class FontComboBox(@NamedArg("fontSize") fontSize: Double = 12.0, @NamedArg("enableStyle") enableStyle: Boolean = false) : JFXComboBox<String>(FXCollections.observableArrayList(Font.getFamilies())) {
    init {
        valueProperty().addListener { _, _, newValue ->
            if (enableStyle)
                style = "-fx-font-family: \"$newValue\";"
        }
        cellFactory = Callback {
            object : ListCell<String>() {
                override fun updateItem(item: String?, empty: Boolean) {
                    super.updateItem(item, empty)
                    item?.apply {
                        text = item
                        font = Font(item, fontSize)
                    }
                }
            }
        }
    }
}