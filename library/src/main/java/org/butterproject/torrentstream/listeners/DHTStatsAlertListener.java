/*
 *    Copyright 2018 Butter Project
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.butterproject.torrentstream.listeners;

import com.frostwire.jlibtorrent.AlertListener;
import com.frostwire.jlibtorrent.DhtRoutingBucket;
import com.frostwire.jlibtorrent.alerts.Alert;
import com.frostwire.jlibtorrent.alerts.AlertType;
import com.frostwire.jlibtorrent.alerts.DhtStatsAlert;

import java.util.ArrayList;

public abstract class DHTStatsAlertListener implements AlertListener {
    @Override
    public int[] types() {
        return new int[]{AlertType.DHT_STATS.swig()};
    }

    public void alert(Alert<?> alert) {
        if (alert instanceof DhtStatsAlert) {
            DhtStatsAlert dhtAlert = (DhtStatsAlert) alert;
            stats(countTotalDHTNodes(dhtAlert));
        }
    }

    public abstract void stats(int totalDhtNodes);

    private int countTotalDHTNodes(DhtStatsAlert alert) {
        final ArrayList<DhtRoutingBucket> routingTable = alert.routingTable();

        int totalNodes = 0;
        if (routingTable != null) {
            for (DhtRoutingBucket bucket : routingTable) {
                totalNodes += bucket.numNodes();
            }
        }

        return totalNodes;
    }
}
