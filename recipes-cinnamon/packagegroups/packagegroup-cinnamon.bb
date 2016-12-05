SUMMARY = "All packages required for a base installation of Cinnamon"
SECTION = "x11/wm"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"
PR = "r0"

inherit packagegroup

# FIXME: This is pretty much a soup at the moment
RDEPENDS_${PN} = " \
    consolekit \
    cinnamon-desktop \
    libcinnamon-desktop \
    cinnamon-menus \
    cinnamon-session \
    libcinnamon-session \
    muffin \
    muffin-glib \
    cinnamon-settings-daemon \
    libcinnamon-settings \
    Cinnamon \
    Cinnamon-data \
    nemo \
    nemo-data \
    cinnamon-screensaver \
    cinnamon-screensaver-data \
    network-manager-applet \
    xdg-utils \
    python-codecs \
    python-textutils \
    python-importlib \
    caribou \
    libcaribou \
    procps \
    gnome-terminal \
    gdb \
    mozjs-24-dbg \
    metacity \
    gnome-themes \
    shared-mime-info \
    gnome-mime-data \
"
