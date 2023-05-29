#!/usr/bin/perl
 
use 5.010;
use strict;
use warnings;
use Tk;

# Create the main window
my $mw = MainWindow->new;
$mw->geometry("400x300");

# Create a notebook (tabbed interface)
my $notebook = $mw->NoteBook()->pack(-fill => 'both', -expand => 1);

# Create Tab 1
my $tab1 = $notebook->add("Tab 1", -label => "File Creation");

# File Name Label and Entry Widget
$tab1->Label(-text => "File Name:")->grid(-column => 0, -row => 0);
my $filename_entry = $tab1->Entry()->grid(-column => 1, -row => 0);

# File Type Label and Entry Widget
$tab1->Label(-text => "File Type:")->grid(-column => 0, -row => 1);
my $filetype_entry = $tab1->Entry()->grid(-column => 1, -row => 1);

# Directory Label and Entry Widget
$tab1->Label(-text => "Directory:")->grid(-column => 0, -row => 2);
my $directory_entry = $tab1->Entry()->grid(-column => 1, -row => 2);

# Submit Button
$tab1->Button(-text => "Create File", -command => \&create_file)->grid(-column => 0, -row => 3, -columnspan => 2);

# Function to create the file
sub create_file {
    my $filename = $filename_entry->get();
    my $filetype = $filetype_entry->get();
    my $directory = $directory_entry->get();

    my $filepath = $directory . "\\" . $filename . "." . $filetype;

    open(my $filehandle, '>', $filepath) or die "Could not create file: $!";
    print $filehandle "This is a new file!\n";
    close($filehandle);

    $tab1->messageBox(-message => "File created successfully!", -type => "ok");
}

# Start the Tk event loop

# File Name Label and Entry Widget
$tab1->Label(-text => "File Name:")->grid(-column => 0, -row => 0);
my $filename_entry = $tab1->Entry()->grid(-column => 1, -row => 0);

# File Type Label and Entry Widget
$tab1->Label(-text => "File Type:")->grid(-column => 0, -row => 1);
my $filetype_entry = $tab1->Entry()->grid(-column => 1, -row => 1);

# Directory Label and Entry Widget
$tab1->Label(-text => "Directory:")->grid(-column => 0, -row => 2);
my $directory_entry = $tab1->Entry()->grid(-column => 1, -row => 2);

# Submit Button
$tab1->Button(-text => "Create File", -command => \&create_file)->grid(-column => 0, -row => 3, -columnspan => 2);

# Function to create the file
sub create_file {
    my $filename = $filename_entry->get();
    my $filetype = $filetype_entry->get();
    my $directory = $directory_entry->get();

    my $filepath = $directory . "\\" . $filename . "." . $filetype;

    open(my $filehandle, '>', $filepath) or die "Could not create file: $!";
    print $filehandle "This is a new file!\n";
    close($filehandle);

    $tab1->messageBox(-message => "File created successfully!", -type => "ok");
}

# Create Tab 2
my $tab2 = $notebook->add("Tab 2", -label => "File Modification");

# File Selection Button
$tab2->Button(
    -text    => "Select File",
    -command => \&select_file
)->pack(-padx => 10, -pady => 10);

# Text Widget for File Content
my $text_widget = $tab2->Text()->pack(-fill => 'both', -expand => 1);

# Save File Button
$tab2->Button(
    -text    => "Save File",
    -command => \&save_file
)->pack(-padx => 10, -pady => 10);

# File Selection Dialog
my $selected_file = '';
sub select_file {
    my $fs = $mw->FileSelect();
    $selected_file = $fs->Show();
    
    if ($selected_file) {
        open(my $fh, '<', $selected_file) or die "Could not open file: $!";
        my @lines = <$fh>;
        close($fh);

        $text_widget->delete('1.0', 'end');
        $text_widget->insert('1.0', @lines);
    }
}

# Save File Function
sub save_file {
    return unless $selected_file;
    
    my $content = $text_widget->get('1.0', 'end');
    
    open(my $fh, '>', $selected_file) or die "Could not open file: $!";
    print $fh $content;
    close($fh);
    
    $tab2->messageBox(-message => "File saved successfully!", -type => "ok");
}

# Create Tab 3
my $tab3 = $notebook->add("Tab 3", -label => "File Retrieval");

# File Retrieval Button
$tab3->Button(
    -text    => "Retrieve File",
    -command => \&select_display_file
)->pack(-padx => 10, -pady => 10);

my $display_text_widget = $tab3->Text()->pack(-fill => 'both', -expand => 1);

# Function to retrieve the File
sub select_display_file {
    my $fs = $mw->FileSelect(
        -directory => '/path/to/directory',  # Replace with the desired directory path
    );
    my $selected_file = $fs->Show();

    if ($selected_file) {
        # Open the selected file and read its content
        open(my $fh, '<', $selected_file) or die "Could not open file: $!";
        my @lines = <$fh>;
        close($fh);

        # Display the file content in the text widget
         $display_text_widget->delete('1.0', 'end');
        $display_text_widget->insert('1.0', @lines);
    }

# Create Tab 4
my $tab4 = $notebook->add("Tab 4", -label => "Tab 4");
my $label4 = $tab4->Label(-text => "Content for Tab 4")->pack(-padx => 10, -pady => 10);

# Create Tab 5
my $tab5 = $notebook->add("Tab 5", -label => "Tab 5");
my $label5 = $tab5->Label(-text => "Content for Tab 5")->pack(-padx => 10, -pady => 10);

# Create Tab 6
my $tab6 = $notebook->add("Tab 6", -label => "Tab 6");
my $label6 = $tab6->Label(-text => "Content for Tab 6")->pack(-padx => 10, -pady => 10);



sub tab2_action {
    # Action for Tab 2
    print "Clicked Tab 2\n";
}

sub tab3_action {
    # Action for Tab 3
    print "Clicked Tab 3\n";
}

sub tab4_action {
    # Action for Tab 4
    print "Clicked Tab 4\n";
}

sub tab5_action {
    # Action for Tab 5
    print "Clicked Tab 5\n";
}

sub tab6_action {
    # Action for Tab 6
    print "Clicked Tab 6\n";
}

# Start the Tk event loop
MainLoop;
