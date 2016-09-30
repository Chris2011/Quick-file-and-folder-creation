package org.chrisle.netbeans.plugins.quickfileandfolder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.chrisle.netbeans.plugins.quickfileandfolder.creationdialog.CreationDialog;
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
    displayName = "#CTL_QuickFolderAction"
)

@ActionReferences({
    @ActionReference(path = "Loaders/folder/any/Actions", position = 0),
    @ActionReference(path = "Projects/package/Actions", position = 0),
    @ActionReference(path = "Shortcuts", name = "CA-P CA-P")
})
@Messages("CTL_QuickFolderAction=New Folder")
public final class QuickFolderAction implements ActionListener {
    private static DataObject _context;
    private static final CreationDialog _creationDialog = new CreationDialog();

    public QuickFolderAction(DataObject context) {
        _context = context;
        
        _creationDialog.setContext(_context);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        _creationDialog.setVisible(true);
    }
    
    public static void createNewDir(String dirName) {
        FileObject primaryFile;
        
        primaryFile = _context.getPrimaryFile();
            
        File currentDir = new File(primaryFile.getPath());
        File newDir = new File(currentDir, dirName);
        
        if (dirExists(dirName)) {
            _creationDialog.setErrorLabelVisible(true);
            
            return;
        }
        
        newDir.mkdirs();
    }
    
    public static boolean dirExists(String dirName) {
        FileObject primaryFile;
        
        primaryFile = _context.getPrimaryFile();
        
        Path path = Paths.get(primaryFile.getPath() + "/" + dirName);
        
        return Files.exists(path);
    }
}