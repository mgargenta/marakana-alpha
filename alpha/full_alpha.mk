$(call inherit-product, $(SRC_TARGET_DIR)/product/languages_small.mk)
$(call inherit-product, $(SRC_TARGET_DIR)/product/generic.mk)

PRODUCT_PACKAGES += \
	MrknLogLibClient \
	MrknLogServiceClient \

include device/marakana/alpha-common/alpha.mk

include $(call all-makefiles-under,$(LOCAL_PATH))

# Discard inherited values and use our own instead.
PRODUCT_NAME := full_marakana_alpha
PRODUCT_DEVICE := alpha
PRODUCT_MODEL := Full Marakana Alpha Image for Emulator
