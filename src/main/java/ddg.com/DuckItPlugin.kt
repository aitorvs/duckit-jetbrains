package ddg.com

import com.intellij.ide.browsers.BrowserLauncher
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import java.net.URLEncoder

class DuckItPlugin : AnAction("Duck It") {
  override fun update(e: AnActionEvent) {
    super.update(e)
    e.presentation.isEnabled = true
  }

  override fun actionPerformed(event: AnActionEvent) {
    val editor = event.getData(PlatformDataKeys.EDITOR) ?: return
    var selectedText = editor.selectionModel.selectedText ?: return

    selectedText = selectedText.trim()
    if (selectedText.isEmpty()) {
      return
    }
    try {
      val url = "https://duckduckgo.com/?q=" + URLEncoder.encode(selectedText, "UTF-8")
      BrowserLauncher.instance.browse(url, null)
    } catch (e: Throwable) {
      return
    }
  }
}
