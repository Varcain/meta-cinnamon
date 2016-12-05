SUMMARY = "gusb"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"
DEPENDS = "intltool-native libusb1"

SRC_URI = " \
    https://github.com/hughsie/libgusb/archive/gusb_0_2_9.tar.gz \
  "

SRC_URI[md5sum] = "34633a2e01573027b9055fdbe4868b5e"
SRC_URI[sha256sum] = "961034ba64f8e19de6707ca1bc59f0f190b2f19af8bbf0d974d2d616efab0094"

S = "${WORKDIR}/libgusb-gusb_0_2_9"

inherit autotools pkgconfig gtk-doc gobject-introspection vala
