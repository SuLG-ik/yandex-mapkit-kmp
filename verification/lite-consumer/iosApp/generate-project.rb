require 'xcodeproj'

project = Xcodeproj::Project.new('LiteConsumerApp.xcodeproj')
target = project.new_target(:application, 'LiteConsumerApp', :ios, '15.0')
source = project.main_group.new_file('LiteConsumerApp.swift')
target.add_file_references([source])
target.build_configurations.each do |configuration|
  configuration.build_settings.merge!(
    'PRODUCT_BUNDLE_IDENTIFIER' => 'ru.sulgik.liteconsumer',
    'GENERATE_INFOPLIST_FILE' => 'YES',
    'INFOPLIST_FILE' => 'Info.plist',
    'MARKETING_VERSION' => '1.0',
    'CURRENT_PROJECT_VERSION' => '1',
    'SWIFT_VERSION' => '5.0'
  )
end
project.recreate_user_schemes
project.save
