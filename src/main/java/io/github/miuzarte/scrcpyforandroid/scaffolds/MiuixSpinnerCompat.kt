package io.github.miuzarte.scrcpyforandroid.scaffolds

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import top.yukonga.miuix.kmp.basic.SpinnerDefaults
import top.yukonga.miuix.kmp.basic.SpinnerEntry
import top.yukonga.miuix.kmp.basic.SpinnerItemImpl
import top.yukonga.miuix.kmp.preference.WindowSpinnerPreference

/**
 * miuix Spinner 系列（WindowSpinnerPreference/SpinnerEntry/SpinnerItemImpl/SpinnerDefaults）
 * 的兼容封装层。
 *
 * miuix 0.9.1 起 Spinner 系列已废弃并迁移至 Dropdown 系列，
 * 后续升级 miuix 时只需修改本文件内部实现，无需改动业务调用方。
 */
data class MiuixSpinnerOption(
    val icon: (@Composable (Modifier) -> Unit)? = null,
    val title: String? = null,
    val summary: String? = null,
)

@Composable
fun MiuixSpinnerPreference(
    title: String,
    options: List<MiuixSpinnerOption>,
    selectedIndex: Int,
    modifier: Modifier = Modifier,
    summary: String? = null,
    enabled: Boolean = true,
    onSelectedIndexChange: ((Int) -> Unit)? = null,
) {
    WindowSpinnerPreference(
        title = title,
        items = options.map { SpinnerEntry(icon = it.icon, title = it.title, summary = it.summary) },
        selectedIndex = selectedIndex,
        modifier = modifier,
        summary = summary,
        enabled = enabled,
        onSelectedIndexChange = onSelectedIndexChange,
    )
}

@Composable
fun MiuixSpinnerItem(
    option: MiuixSpinnerOption,
    entryCount: Int,
    isSelected: Boolean,
    index: Int,
    dialogMode: Boolean = false,
    onSelectedIndexChange: (Int) -> Unit,
) {
    SpinnerItemImpl(
        entry = SpinnerEntry(icon = option.icon, title = option.title, summary = option.summary),
        entryCount = entryCount,
        isSelected = isSelected,
        index = index,
        spinnerColors = SpinnerDefaults.spinnerColors(),
        dialogMode = dialogMode,
        onSelectedIndexChange = onSelectedIndexChange,
    )
}
