HOMEPAGE = "https://github.com/linuxmint"
SRC_URI = "https://github.com/linuxmint/${PN}/archive/${PV}.tar.gz;downloadfilename=${BPN}_${PV}.tar.gz"

inherit autotools pkgconfig gettext gtk-icon-cache

DEPENDS += "intltool-native"
