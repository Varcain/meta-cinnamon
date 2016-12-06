SUMMARY = "Cinnamon Settings Daemon"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"
DEPENDS = "libnotify upower lcms libgnomekbd colord libvorbis libogg libcanberra libsndfile1 libtool cinnamon-desktop nss"

inherit cinnamon autotools pkgconfig gettext gobject-introspection

SRC_URI[md5sum] = "c0b815a88d7512f1575af2b8e2a57b15"
SRC_URI[sha256sum] = "0abe839e04a36a052bb486f90e84c25ae6ccc92b74223813d9666eaac257677b"

EXTRA_OECONF = "--disable-cups --disable-man"

FILES_${PN} += " \
    ${libdir}/cinnamon-settings-daemon-3.0/* \
    ${datadir}/icons/* \
    ${datadir}/dbus-1/* \
    ${datadir}/cinnamon-settings-daemon-3.0/* \
    ${datadir}/polkit-1/* \
    ${datadir}/glib-2.0/* \
"
