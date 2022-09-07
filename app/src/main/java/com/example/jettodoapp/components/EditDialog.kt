package com.example.jettodoapp.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jettodoapp.MainViewModel

@Composable
fun EditDialog(
    isShowDialog: MutableState<Boolean>,
    viewModel: MainViewModel = hiltViewModel(),
) {
    AlertDialog(
        onDismissRequest = { isShowDialog.value = false },
        title = { Text(text = "タスク新規作成") },
        text = {
            Column {
                Text(text = "タイトル")
                TextField(
                    value = viewModel.title,
                    onValueChange = { viewModel.title = it },
                )
                Text(text = "詳細")
                TextField(
                    value = viewModel.description,
                    onValueChange = { viewModel.description = it },
                )
            }
        },
        buttons = {
            Row(modifier = Modifier.padding(8.dp)) {
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    modifier = Modifier.width(120.dp),
                    onClick = { isShowDialog.value = false },
                ) {
                    Text(text = "キャンセル")
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(
                    modifier = Modifier.width(120.dp),
                    onClick = {
                        isShowDialog.value = false
                        /* todo */
                    },
                ) {
                    Text(text = "OK")
                }
            }
        },
    )
}