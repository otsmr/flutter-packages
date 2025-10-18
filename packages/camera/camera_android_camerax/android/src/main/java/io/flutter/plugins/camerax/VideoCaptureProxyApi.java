// Copyright 2013 The Flutter Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package io.flutter.plugins.camerax;

import androidx.annotation.NonNull;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.VideoOutput;
import androidx.camera.core.MirrorMode;

/**
 * ProxyApi implementation for {@link VideoCapture}. This class may handle instantiating native
 * object instances that are attached to a Dart instance or handle method calls on the associated
 * native class or an instance of that class.
 */
class VideoCaptureProxyApi extends PigeonApiVideoCapture {
  VideoCaptureProxyApi(@NonNull ProxyApiRegistrar pigeonRegistrar) {
    super(pigeonRegistrar);
  }

  @NonNull
  @Override
  public VideoCapture<?> withOutput(@NonNull VideoOutput videoOutput) {
    // https://developer.android.com/reference/kotlin/androidx/camera/core/MirrorMode?hl=en#MIRROR_MODE_ON_FRONT_ONLY()
    return new VideoCapture.Builder<>(videoOutput)
      .setMirrorMode(MirrorMode.MIRROR_MODE_ON_FRONT_ONLY)
      .build();
  }

  @NonNull
  @Override
  public VideoOutput getOutput(VideoCapture<?> pigeonInstance) {
    return pigeonInstance.getOutput();
  }

  @Override
  public void setTargetRotation(VideoCapture<?> pigeonInstance, long rotation) {
    pigeonInstance.setTargetRotation((int) rotation);
  }
}
