package io.github.astrapi69.design.pattern.visitor.example.tree;

import io.github.astrapi69.design.pattern.visitor.Visitor;
import lombok.Getter;

import java.util.LinkedHashSet;
import java.util.Set;

public class TraverseSimpleTreeNodeVisitor<T> implements Visitor<SimpleTreeNode<T>>
{

	@Getter
	final Set<SimpleTreeNode<T>> allTreeNodes = new LinkedHashSet<>();

	@Override
	public void visit(SimpleTreeNode<T> simpleTreeNode)
	{
		allTreeNodes.add(simpleTreeNode);
	}
}
