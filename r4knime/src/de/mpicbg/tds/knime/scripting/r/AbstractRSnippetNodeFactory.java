package de.mpicbg.tds.knime.scripting.r;

import de.mpicbg.tds.knime.scripting.r.prefs.RPreferenceInitializer;
import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;


/**
 * Document me!
 *
 * @author Holger Brandl
 */
public abstract class AbstractRSnippetNodeFactory extends NodeFactory<RSnippetNodeModel> {


    @Override
    public int getNrNodeViews() {
        return 0;
    }


    @Override
    public NodeView<RSnippetNodeModel> createNodeView(final int viewIndex,
                                                      final RSnippetNodeModel nodeModel) {
//        return new RSnippetNodeView(nodeModel);
        return null;
    }


    @Override
    public boolean hasDialog() {
        return true;
    }


    @Override
    public NodeDialogPane createNodeDialogPane() {
        String templateResources = R4KnimeBundleActivator.getDefault().getPreferenceStore().getString(RPreferenceInitializer.R_SNIPPET_TEMPLATES);
        return new RSnippetNodeDialog(RUtils.SCRIPT_PROPERTY_DEFAULT, templateResources, true, enableTemplateRepository());
    }


    protected boolean enableTemplateRepository() {
        return true;
    }
}