package com.erdin.arkaandroidtwo.webview

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.erdin.arkaandroidtwo.R
import com.erdin.arkaandroidtwo.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity(), WebViewListener {
    private lateinit var binding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_web_view)

        binding.webView.loadUrl("https://mojok.co/")

        binding.webView.webChromeClient = MojokChromeClient(this)
        binding.webView.webViewClient = MojokWebClient(this)

    }

    class MojokChromeClient(private var listener: WebViewListener) : WebChromeClient() {
        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            listener.onProgressChange(newProgress)
            super.onProgressChanged(view, newProgress)
        }
    }

    class MojokWebClient(private var listener: WebViewListener) : WebViewClient() {
        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            listener.onPageStarted()
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            listener.onPageFinish()
        }

        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                listener.onShouldOverrideUrl(request?.url?.toString().orEmpty())
            }
            return super.shouldOverrideUrlLoading(view, request)
        }


    }

    override fun onPageStarted() {
        binding.progressBar.visibility = View.VISIBLE
        Toast.makeText(this, "Page Started", Toast.LENGTH_SHORT).show()
    }

    override fun onPageFinish() {
        binding.progressBar.visibility = View.GONE
        Toast.makeText(this, "Page Finsihed", Toast.LENGTH_SHORT).show()
    }

    override fun onShouldOverrideUrl(redirectUrl: String) {
        Toast.makeText(this, "redirect url: $redirectUrl", Toast.LENGTH_SHORT).show()
    }

    override fun onProgressChange(progress: Int) {
        binding.progressBar.progress = progress
    }
}