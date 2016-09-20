package org.chrisle.netbeans.plugins.quickfileandfolder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.loaders.DataObject;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.filesystems.FileObject;
import org.openide.util.NbBundle.Messages;

@ActionID(
    category = "Tools",
    id = "org.chrisle.netbeans.plugins.quickfileandfolder.QuickFileAndFolderAction"
)
@ActionRegistration(
    displayName = "#CTL_QuickFileAndFolderAction"
)

@ActionReferences({
    @ActionReference(path = "Loaders/folder/any/Actions", position = 0),
    @ActionReference(path = "Projects/package/Actions", position = 0),
    @ActionReference(path = "Shortcuts", name = "CA-P CA-P")
})
@Messages("CTL_QuickFileAndFolderAction=New Folder")
public final class QuickFileAndFolderAction implements ActionListener {
    private final DataObject _context;
    private int _folderCounter = 1;

    public QuickFileAndFolderAction(DataObject context) {
        this._context = context;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        FileObject primaryFile = null;

//        try {
//            primaryFile = _context.getPrimaryFile();
//            
//            File currentDir = new File(primaryFile.getPath());
//            File newDir = new File(currentDir, "New Folder");
//            
//            if (newDir.exists()) {
//                newDir = new File(currentDir, "New Folder" + ++_folderCounter);
//            }
//
//            newDir.mkdirs();
//        } catch (Exception e) {
//            
//        }
    }
}