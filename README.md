TorrentStream-Android
======

A torrent streamer library for Android based on [jlibtorrent](https://github.com/frostwire/frostwire-jlibtorrent).

Once built for the Popcorn Time and the [Butterproject](https://github.com/butterproject/butter-android). Now just a cool library for anyone to use.

## How to use

Add to your dependencies:

```groovy
dependencies {
    api "com.butterproject.torrentstream.torrent-stream:2.5.0"
}
```

Add to your AndroidManifest.xml (only for saving to the external storage):

```xml
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
```

### Code samples

Create your own `TorrentOptions` instance using the builder and feed it to a new `TorrentStream`.

```java
TorrentOptions torrentOptions = new TorrentOptions.Builder()
                .saveLocation(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS))
                .removeFilesAfterStop(true)
                .build();

TorrentStream torrentStream = TorrentStream.init(torrentOptions);
torrentStream.startStream("http://distribution.bbb3d.renderfarming.net/video/mp4/bbb_sunflower_1080p_60fps_normal.mp4.torrent");
```

If you want to get status information about the torrent then you might want to use `addListener` to attach a listener to your `TorrentStream` instance.

## License

    Copyright 2018 Butter Project

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
