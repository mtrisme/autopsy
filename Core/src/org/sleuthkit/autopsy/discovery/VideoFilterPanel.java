/*
 * Autopsy
 *
 * Copyright 2020 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.discovery;

import org.sleuthkit.autopsy.centralrepository.datamodel.CentralRepository;

/**
 * Panel for displaying all filters available for the searches of type Video.
 */
final class VideoFilterPanel extends AbstractFiltersPanel {

    private static final long serialVersionUID = 1L;
    private static final FileSearchData.FileType FILE_TYPE = FileSearchData.FileType.VIDEO;

    /**
     * Creates new form VideoFilterPanel.
     */
    VideoFilterPanel() {
        super();
        initComponents();
        SizeFilterPanel sizeFilterPanel = new SizeFilterPanel(FILE_TYPE);
        int[] sizeIndicesSelected = {3, 4, 5};
        addFilter(sizeFilterPanel, true, sizeIndicesSelected, 0);
        addFilter(new DataSourceFilterPanel(), false, null, 0);
        int[] pastOccurrencesIndices;
        if (!CentralRepository.isEnabled()) {
            pastOccurrencesIndices = new int[]{0};
        } else {
            pastOccurrencesIndices = new int[]{2, 3, 4};
        }
        addFilter(new PastOccurrencesFilterPanel(), true, pastOccurrencesIndices, 0);
        addFilter(new UserCreatedFilterPanel(), false, null, 1);
        addFilter(new HashSetFilterPanel(), false, null, 1);
        addFilter(new InterestingItemsFilterPanel(), false, null, 1);
        addFilter(new ObjectDetectedFilterPanel(), false, null, 1);
        addFilter(new ParentFolderFilterPanel(), false, null, 1);
        addPanelsToScrollPane(videoFiltersSplitPane);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JScrollPane videoFiltersScrollPane = new javax.swing.JScrollPane();
        javax.swing.JPanel videoFiltersPanel = new javax.swing.JPanel();
        videoFiltersSplitPane = new javax.swing.JSplitPane();

        setLayout(new java.awt.BorderLayout());

        videoFiltersScrollPane.setPreferredSize(new java.awt.Dimension(312, 102));

        videoFiltersPanel.setPreferredSize(new java.awt.Dimension(310, 100));

        videoFiltersSplitPane.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(VideoFilterPanel.class, "VideoFilterPanel.videoFiltersSplitPane.border.title"))); // NOI18N
        videoFiltersSplitPane.setResizeWeight(0.5);

        javax.swing.GroupLayout videoFiltersPanelLayout = new javax.swing.GroupLayout(videoFiltersPanel);
        videoFiltersPanel.setLayout(videoFiltersPanelLayout);
        videoFiltersPanelLayout.setHorizontalGroup(
            videoFiltersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(videoFiltersPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(videoFiltersSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );
        videoFiltersPanelLayout.setVerticalGroup(
            videoFiltersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(videoFiltersPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(videoFiltersSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );

        videoFiltersScrollPane.setViewportView(videoFiltersPanel);

        add(videoFiltersScrollPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    @Override
    FileSearchData.FileType getFileType() {
        return FILE_TYPE;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSplitPane videoFiltersSplitPane;
    // End of variables declaration//GEN-END:variables

}
