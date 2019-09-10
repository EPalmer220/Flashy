package com.example.flashy;

public class Vocab {
    String[] terms = {"Blame", "Branch", "Clone", "Collaborator", "Commit", "Diff", "Fetch", "Fork",
            "Issue", "Merge", "Private Repository", "Pull","Pull Request", "Push", "Repository"};

    String[] definitions = {"This feature displays the author and time of a revision. Helpful in identifying which commit led to a bug.",
            "A parallel version of a repository. It doesn't affect the master branch, allowing you to work freely without disrupting the" +
            " \"live\" version.", "A copy of a repository that lives on your computer instead of on a website's server, or the act of " +
            "making that copy. When you're online, you can push your local changes from the copy to the remote.","A person who can " +
            "read and write to a repository as per invite by the repository owner.", "An individual change to a file or set of files. " +
            "A.k.a. a revision.", "The difference in changes between two commits, or saved changes. The diff will visually" +
            " describe what was added or removed from a file since its last commit.", "The act of downloading the latest version of " +
            "a git repository from online.", "A personal copy of another user's repository that lives on your account. This copy " +
            "enables you to freely change a project without affecting the original.", "A suggested improvement, task, or question" +
            " related to a repository. Issues can be suggested by anyone (if the repo is public), and are moderated by repository" +
            " collaborators.", "The act of integrating the changes from one branch (in the same repository or from a fork) into" +
            " another. This can be done either automatically, via a pull request, or via the command line.", "A repository that" +
            " can only be viewed or contributed to by their creator and collaborators the creator specified.", "The act of either" +
            " fetching changes or merging them.", "Proposed changes to a repository, submitted by a user and accepted or rejected " +
            "by a repository's collaborators.", "The act of sending your committed changes to a remote repository.", "A project's " +
            "folder, containing all the project files (including documentation) and storing each file's revision history. The can " +
            "have multiple collaborators and either be public or private."};

    /**
     * @param x the index of the term to be returned
     * @return term specified at index x
     */
    public String getTerm(int x) { return terms[x]; }

    /**
     * @return number of spaces in String[] terms
     */
    public int getTermsLength(){
        return terms.length;
    }

    /**
     * @return number of spaces in String[] definitions
     */
    public int getDefsLength() { return definitions.length; }

    /**
     * @param x the index of the definition to be returned
     * @return definition specified at index x
     */
    public String getDefinition(int x){
        return definitions[x];
    }

    /**
     * removes specified definition from String[] definitions
     * @param definition the definition to be removed
     */
    public void remove(String definition){
        String[] newDefs = new String[definitions.length -1];

        for(int j = 0, l = 0; j < definitions.length; j++) {
            if(!definitions[j].equals(definition))
                newDefs[l++] = definitions[j];
        }

        this.definitions = newDefs;

    }

    /**
     * @param definition the CharSequence to be searched for within String[] definitions
     * @return  returns the index of the specified CharSequence
     */
    public int getIndexOfDefinition(CharSequence definition){
        for(int i = 0; i < definitions.length; i++){
            if(definitions[i].equals(definition))
                return i;
        }
        return -1;
    }



}
