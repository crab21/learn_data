修改的文件如下：


编辑.gnomerc文件（如果之前没有被创建）：vi ~/.gnomerc

GNOME在启动时会自动寻找.gnomerc文件并启动其中所需启动的内容。
在这个.gnomerc文件中输入以下内容，即可实现fcitx开机自启动。

export XIM_PROGRAM=fcitx
export XIM=fcitx
export XMODIFIERS="@im=fcitx"
fcitx& 


